package snack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 간식 정보를 파일에 저장하고 불러오는 DAO 구현체
public class TextFileHashMapSnackDAO implements SnackDAO {
    // 간식 번호와 SnackVO 객체를 저장하는 Map
    private Map<Integer, SnackVO> snack = new HashMap<>();
    // 다음 간식 번호를 관리하는 변수
    private int nextNo = 1;
    // 데이터 파일 경로
    private final String DATA_FILE = "./data/snack.txt";

    // 생성자에서 기존 데이터 파일 로딩
    public TextFileHashMapSnackDAO() {
        loadSnacks();
    }

    // 데이터 파일에서 간식 목록을 읽어와 Map에 저장
    private void loadSnacks() {
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            // 파일이 없으면 로딩하지 않고 종료
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int maxNo = 0; // 현재까지 최대 번호를 추적
            while ((line = br.readLine()) != null) {
                // 콤마(,)로 구분된 필드 분리
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    int no = Integer.parseInt(parts[0]);         // 간식 번호
                    String name = parts[1];                      // 이름
                    String company = parts[2];                   // 회사명
                    String country = parts[3];                   // 원산지
                    int price = Integer.parseInt(parts[4]);      // 가격
                    int stock = Integer.parseInt(parts[5]);      // 재고
                    String category = parts[6];                   // 분류
                    // SnackVO 객체 생성
                    SnackVO snackVO = new SnackVO(no, name, company, country, price, stock, category);
                    snack.put(no, snackVO);
                    // 최대 번호 업데이트
                    if (no > maxNo) maxNo = no;
                }
            }
            // 다음 번호는 최대 번호 + 1
            nextNo = maxNo + 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 간식 정보를 파일에 저장 (Map 전체 내용을 저장)
    private void saveSnacks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (SnackVO snackVO : snack.values()) {
                String line = snackVO.getSnackNo() + "," +
                              snackVO.getName() + "," +
                              snackVO.getCompany() + "," +
                              snackVO.getCountry() + "," +
                              snackVO.getPrice() + "," +
                              snackVO.getStock() + "," +
                              snackVO.getCategory();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertSnack(SnackVO snackVO) {
        // 새 간식에 번호 할당
        snackVO.setSnackNo(nextNo++);
        // Map에 추가
        snack.put(snackVO.getSnackNo(), snackVO);
        // 파일에 저장
        saveSnacks();
    }

    @Override
    public List<SnackVO> selectAllSnacks() {
        // 모든 간식을 리스트로 반환
        return new ArrayList<>(snack.values());
    }

    @Override
    public SnackVO selectSnack(int snackNo) {
        // 번호로 간식 조회
        return snack.get(snackNo);
    }

    @Override
    public void updateSnack(SnackVO snackVO) {
        // 기존 간식 정보 덮어쓰기
        snack.put(snackVO.getSnackNo(), snackVO);
        // 파일에 저장
        saveSnacks();
    }

    @Override
    public boolean deleteSnack(int snackNo) {
        // 삭제 성공 시 true 반환
        if (snack.remove(snackNo) != null) {
            saveSnacks();
            return true;
        }
        return false;
    }

    @Override
    public int getStock(int snackNo) {
        SnackVO snackVO = snack.get(snackNo);
        // 간식이 존재하면 재고 반환, 아니면 0
        return (snackVO != null) ? snackVO.getStock() : 0;
    }

    @Override
    public void reduceStock(int snackNo, int quantity) {
        SnackVO snackVO = snack.get(snackNo);
        if (snackVO != null) {
            int newStock = snackVO.getStock() - quantity;
            // 재고는 0 미만으로 떨어지지 않도록 제한
            snackVO.setStock(Math.max(newStock, 0));
            saveSnacks();
        }
    }

    @Override
    public int getNextSnackNo() {
        return nextNo;
    }
}
