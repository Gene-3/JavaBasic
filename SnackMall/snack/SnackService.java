package snack;

import java.util.List;
import java.util.Scanner;

// 간식 관련 비즈니스 로직 처리 서비스 클래스
public class SnackService {
    private SnackDAO dao;  // DAO 객체 참조

    public SnackService(SnackDAO dao) {
        this.dao = dao;
    }

    // 간식 등록 (파라미터 직접 입력 방식)
    public String registSnack(String name, String company, String country, int price, int stock, String category) {
        int snackNo = dao.getNextSnackNo(); // 다음 자동 번호 받아옴
        SnackVO snack = new SnackVO(snackNo, name, company, country, price, stock, category);
        dao.insertSnack(snack);  // DAO 통해 저장
        return "간식이 등록되었습니다.";
    }
    
    // 특정 간식 정보를 SnackVO 객체로 반환하는 메서드
    public SnackVO getSnackVO(int snackNo) {
        return dao.selectSnack(snackNo);
    }

    // 간식 등록 (Scanner로 입력받아 처리)
    public String registSnack(Scanner sc) {
        try {
            System.out.print("간식 이름: ");
            String name = sc.nextLine().trim();
            System.out.print("회사명: ");
            String company = sc.nextLine().trim();
            System.out.print("원산지: ");
            String country = sc.nextLine().trim();

            System.out.print("가격: ");
            int price = Integer.parseInt(sc.nextLine().trim());

            System.out.print("재고: ");
            int stock = Integer.parseInt(sc.nextLine().trim());

            System.out.print("분류: ");
            String category = sc.nextLine().trim();

            // 필수 문자열 입력 검사
            if (name.isEmpty() || company.isEmpty() || country.isEmpty() || category.isEmpty()) {
                return "모든 문자열 입력은 반드시 입력해야 합니다.";
            }

            // 가격 및 재고 유효성 검사
            if (price < 0 || stock < 0) {
                return "가격과 재고는 0 이상이어야 합니다.";
            }

            // 등록 메서드 호출
            return registSnack(name, company, country, price, stock, category);

        } catch (NumberFormatException e) {
            return "가격과 재고는 숫자로만 입력해야 합니다.";
        }
    }

    // 등록된 모든 간식 목록 문자열로 반환
    public String listSnacks() {
        List<SnackVO> snacks = dao.selectAllSnacks();
        if (snacks.isEmpty()) return "등록된 간식이 없습니다.";
        StringBuilder sb = new StringBuilder();
        for (SnackVO s : snacks) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }

    // 특정 간식 상세 정보 문자열 반환
    public String detailSnack(int snackNo) {
        SnackVO s = dao.selectSnack(snackNo);
        if (s == null) return "간식을 찾을 수 없습니다.";
        return s.toString();
    }

    // 간식 가격 및 재고 수정
    public String updateSnack(int snackNo, int price, int stock) {
        if (price < 0 || stock < 0) {
            return "가격과 재고는 0 이상이어야 합니다.";
        }
        SnackVO s = dao.selectSnack(snackNo);
        if (s == null) return "간식이 존재하지 않습니다.";
        s.setPrice(price);
        s.setStock(stock);
        dao.updateSnack(s);
        return "수정 완료";
    }

    public String updateSnack(SnackVO snack) {
        if (snack.getPrice() < 0 || snack.getStock() < 0) {
            return "가격과 재고는 0 이상이어야 합니다.";
        }
        SnackVO s = dao.selectSnack(snack.getSnackNo());
        if (s == null) return "간식이 존재하지 않습니다.";
        dao.updateSnack(snack);
        return "수정 완료";
    }

    
    // 간식 재고만 수정
    public String updateSnackStock(int snackNo, int stock) {
        if (stock < 0) {
            return "재고는 0 이상이어야 합니다.";
        }
        SnackVO s = dao.selectSnack(snackNo);
        if (s == null) return "간식이 존재하지 않습니다.";
        s.setStock(stock);
        dao.updateSnack(s);
        return "재고 수정 완료";
    }

    // 간식 삭제
    public boolean deleteSnack(int snackNo) {
        return dao.deleteSnack(snackNo);
    }

    // 간식 존재 여부 확인
    public boolean existsSnack(int snackNo) {
        return dao.selectSnack(snackNo) != null;
    }
    
 // 간식 상세 정보를 SnackVO 객체로 반환
    public SnackVO detailSnackVO(int snackNo) {
        return dao.selectSnack(snackNo);
    }

}
