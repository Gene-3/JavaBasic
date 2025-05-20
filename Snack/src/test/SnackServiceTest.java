package test;

import snack.SnackDAO;
import snack.SnackService;
import snack.SnackVO;
import snack.KJSnackService;
import snack.ListSnackDAO;

public class SnackServiceTest {

	public static void main(String[] args) {
		
		SnackService ss = new KJSnackService(new ListSnackDAO());
		
		// 책 등록
		ss.registSnack(new SnackVO("test", "kopo", 10000, 10));
		ss.registSnack(new SnackVO("test2", "home", 1000, 5));
		ss.registSnack(new SnackVO("test3", "home", 3000, 15));
		
		// 책목록 
		System.out.println(ss.listSnacks());
		
		// 책상세정보
		System.out.println(ss.detailSnackInfo(112));
		
		// 책정보 수정
		ss.updateSnackInstock(111, 15);
		ss.updateSnackPrice(112, 30000);
		
		System.out.println(ss.listSnacks());
		
		//책 삭제
		
		ss.removeSnack(113);
		
		System.out.println(ss.listSnacks());
	}
	
	static void DAOTest() {
        SnackDAO snackDAO = new ListSnackDAO();
		
		
		// 책 등록
		snackDAO.insertSnack(new SnackVO("gyejeong", "kopo", 10000, 10));
		snackDAO.insertSnack(new SnackVO("curi", "home", 1000, 5));
		snackDAO.insertSnack(new SnackVO("hye", "home", 3000, 15));
		// 책 정보
		System.out.println(snackDAO.selectAllSnacks());
		System.out.println(snackDAO.selectSnack(112));
		// 책 정보 수정
		SnackVO snack = snackDAO.selectSnack(111);
		snack.setInstock(15);
		snackDAO.updateSnack(snack);
		
		SnackVO snack1 = snackDAO.selectSnack(112);
		snack1.setPrice(30000);
		snackDAO.updateSnack(snack1);
		
		System.out.println(snackDAO.selectAllSnacks());
		
		// 책 삭제
		snackDAO.deleteSnack(113);
		System.out.println(snackDAO.selectAllSnacks());
	}
}