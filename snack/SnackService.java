package snack;

import java.util.List;

public interface SnackService {
    boolean registSnack(SnackVO snack);
    List<SnackVO> listSnacks();
    boolean updateSnackPrice(int snackNo, int price);
    boolean updateSnackInstock(int snackNo, int instock);
    boolean removeSnack(int snackNo);
    SnackVO detailSnackInfo(int snackNo);
}
