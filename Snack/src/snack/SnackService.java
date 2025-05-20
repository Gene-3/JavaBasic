package snack;

import java.util.List;

public interface SnackService {
	boolean registSnack(SnackVO Snack);
	List<SnackVO> listSnack();
	SnackVO detailSnackInfo(int SnackNo);
	boolean updateSnackPrice(int SnackNo, int price);
	boolean updateSnackInstock(int snackBo, int instock);
	boolean removeSnack(int snackNo);
	List<SnackVO> listSnacks();
}