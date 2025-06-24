package order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextFileHashMapOrderDAO implements OrderDAO {
    private static final String FILE_NAME = "./data/order.txt"; // 주문 데이터 파일 경로
    private int orderSeq = 111; // 주문 번호 시퀀스 초기값

    // 생성자에서 주문 번호 초기화
    public TextFileHashMapOrderDAO() {
        loadOrderSeq();
    }

    // 주문 데이터 파일을 읽어 현재 최대 주문번호를 찾아 orderSeq 초기화
    private void loadOrderSeq() {
        int maxOrderNo = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    // 한 줄을 OrderVO 객체로 변환
                    OrderVO order = OrderVO.fromString(line);

                    // 최대 주문번호 갱신
                    if (order.getOrderId() > maxOrderNo) {
                        maxOrderNo = order.getOrderId();
                    }
                } catch (Exception e) {
                    // 데이터 포맷 오류 발생시 로그 출력하고 계속 진행
                    System.err.println("주문 데이터 파싱 실패: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            // 파일이 없을 경우 초기화 후 정상 진행
            System.out.println("[주문 정보 DB 로딩] " + FILE_NAME + "이 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 최대 주문번호 + 1 을 다음 주문번호로 설정
        orderSeq = maxOrderNo + 1;
    }

    // 주문 저장, 동기화 처리하여 여러 스레드 안전하게 호출 가능
    @Override
    public synchronized void saveOrder(String userId, Map<Integer, Integer> cart) {
        // 새 주문 객체 생성 (주문번호 자동증가)
        OrderVO order = new OrderVO(orderSeq++, userId, cart);
        saveToFile(order);
    }

    // 주문 객체를 파일에 한 줄로 저장
    private void saveToFile(OrderVO order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(order.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 특정 사용자(userId)의 주문 목록 조회 (파일 전체에서 읽어 필터링)
    @Override
    public List<String> getOrdersByUser(String userId) {
        List<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    OrderVO order = OrderVO.fromString(line);

                    if (order.getUserId().equals(userId)) {
                        // 원본 문자열(줄 단위)을 결과 리스트에 추가
                        result.add(line);
                    }
                } catch (Exception e) {
                    System.err.println("주문 데이터 파싱 실패: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // 모든 주문 데이터를 문자열 리스트로 반환 (파일 전체 읽기)
    @Override
    public List<String> getAllOrders() {
        List<String> allOrders = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                allOrders.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allOrders;
    }
}
