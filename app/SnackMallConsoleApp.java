package app;

import java.util.Comparator;
import java.util.List;

import cart.CartService;
import cart.CartServiceImpl;
import cart.HashMapCartDAO;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemberVO;
import member.ObjFileHashMapMemberDAO;
import order.ObjFileHashMapOrderDAO;
import order.OrderService;
import order.OrderServiceImpl;
import snack.ObjFileHashMapSnackDAO;
import snack.SnackService;
import snack.SnackServiceImpl;
import snack.SnackVO;

public class SnackMallConsoleApp {

    String[] startMenuList = {"종료", "간식 목록", "로그인", "회원 가입"};
    String[] adminMenuList = {"로그아웃", "간식 목록", "간식 등록", "간식 정보 수정", "간식 삭제", "회원 목록", "주문 목록"};

    SnackService SS;
    MemberService MS;
    OrderService OS;
    CartService CS;
    MyAppReader input;

    MemberVO loggedMember;

    final String ADMIN_ID = "admin";
    final String ADMIN_PWD = "1234";
    final String ADMIN_NAME = "관리자";

    public SnackMallConsoleApp() {
        SS = new SnackServiceImpl(new ObjFileHashMapSnackDAO());
        MS = new MemberServiceImpl(new ObjFileHashMapMemberDAO());
        OS = new OrderServiceImpl(new ObjFileHashMapOrderDAO(), SS);
        CS = new CartServiceImpl(new HashMapCartDAO());
        input = new MyAppReader();
    }

    public static void main(String[] args) {
        SnackMallConsoleApp app = new SnackMallConsoleApp();
        app.displayWelcome();
        app.controlStartMenu();
    }

    private void displayWelcome() {
        System.out.println("************************************");
        System.out.println("*  Welcome to KwangJin Snack Mart  *");
        System.out.println("************************************");
    }

    private void controlStartMenu() {
        int menu;
        do {
            menu = selectMenu(startMenuList);
            switch (menu) {
                case 1 -> menuSnackList();
                case 2 -> menuLogin();
                case 3 -> menuSignUp();
                case 0 -> menuExit();
                default -> menuWrongNumber();
            }
        } while (menu != 0);
    }

    private int selectMenu(String[] menuList) {
        for (int i = 1; i < menuList.length; i++) {
            System.out.println(i + ". " + menuList[i]);
        }
        System.out.println("0. " + menuList[0]);
        System.out.println("---------------------------------------");
        return input.readInt(">> 메뉴 선택 : ");
    }

    private void menuSnackList() {
        System.out.println("*** 간식 목록 ***");
        List<SnackVO> snackList = SS.listSnacks();
        if (snackList.isEmpty()) {
            System.out.println("등록된 간식이 없습니다.");
            return;
        }
        snackList.sort(Comparator.comparing(SnackVO::getSnackName));
        snackList.forEach(System.out::println);
    }

    private void menuLogin() {
        System.out.println("*** 로그인 ***");
        String id = input.readString(">> ID : ");
        String pwd = input.readString(">> 비밀번호 : ");

        if (id.equals(ADMIN_ID) && pwd.equals(ADMIN_PWD)) {
            loggedMember = new MemberVO(ADMIN_ID, ADMIN_PWD, ADMIN_NAME, "010-0000-0000");
            loggedMember.setGrade(1);
            System.out.println("관리자 모드로 전환합니다.");
            controlAdminMenu();
        } else {
            loggedMember = MS.login(id, pwd);
            if (loggedMember != null) {
                System.out.println("[로그인 성공] " + loggedMember.getName() + "님 환영합니다.");
                // controlMemberMenu(); 추후 구현
            } else {
                System.out.println("[로그인 실패] 회원 정보가 일치하지 않습니다.");
            }
        }
    }

    private void menuSignUp() {
        System.out.println("*** 회원 가입 ***");
        String id = input.readString(">> ID : ");
        String pwd = input.readString(">> 비밀번호 : ");
        String name = input.readString(">> 이름 : ");
        String phone = input.readString(">> 전화번호 : ");
        boolean result = MS.joinMember(new MemberVO(id, pwd, name, phone));
        if (result) {
            System.out.println("회원 가입이 완료되었습니다. 로그인해주세요.");
        } else {
            System.out.println("회원 가입에 실패했습니다.");
        }
    }

    private void menuExit() {
        System.out.println("KwangJin Snack Mart 서비스를 종료합니다.");
    }

    private void menuWrongNumber() {
        System.out.println("없는 메뉴입니다. 다시 선택해주세요.");
    }

    private void controlAdminMenu() {
        int menu;
        do {
            menu = selectMenu(adminMenuList);
            switch (menu) {
                case 1 -> menuSnackList();
                case 2 -> menuRegisterSnack();
                case 3 -> menuUpdateSnack();
                case 4 -> menuDeleteSnack();
                case 5 -> menuMemberList();
                case 6 -> menuOrderList();
                case 0 -> {
                    loggedMember = null;
                    System.out.println("[로그아웃] 관리자 모드 종료.");
                }
                default -> menuWrongNumber();
            }
        } while (loggedMember != null && loggedMember.getGrade() == 1);
    }

    private void menuRegisterSnack() {
        System.out.println("*** 간식 등록 ***");
        String name = input.readString("간식 이름 : ");
        String country = input.readString("국가 : ");
        String category = input.readString("카테고리 : ");
        int price = input.readInt("가격 : ");
        if (SS.registerSnack(new SnackVO(name, country, category, price))) {
            System.out.println("간식 등록 성공");
        } else {
            System.out.println("간식 등록 실패");
        }
    }

    private void menuUpdateSnack() {
        System.out.println("*** 간식 수정 ***");
        String name = input.readString("수정할 간식 이름 : ");
        SnackVO snack = SS.findByName(name);
        if (snack == null) {
            System.out.println("간식이 존재하지 않습니다.");
            return;
        }
        String country = input.readString("국가 : ");
        String category = input.readString("카테고리 : ");
        int price = input.readInt("가격 : ");
        snack.setCountry(country);
        snack.setCategory(category);
        snack.setPrice(price);
        SS.updateSnack(snack);
        System.out.println("간식 정보 수정 완료");
    }

    private void menuDeleteSnack() {
        System.out.println("*** 간식 삭제 ***");
        String name = input.readString("삭제할 간식 이름 : ");
        if (SS.deleteSnack(name)) {
            System.out.println("간식 삭제 완료");
        } else {
            System.out.println("간식 삭제 실패");
        }
    }

    private void menuMemberList() {
        System.out.println("*** 전체 회원 목록 ***");
        List<MemberVO> list = MS.getAllMembers();
        if (list.isEmpty()) {
            System.out.println("회원이 없습니다.");
            return;
        }
        list.forEach(System.out::println);
    }

    private void menuOrderList() {
        System.out.println("*** 주문 목록 ***");
        OS.getAllOrders().forEach(System.out::println);
    }
}
