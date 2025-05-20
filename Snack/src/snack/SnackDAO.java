package snack;

import java.util.List;

public interface SnackDAO {
	boolean insertSnack(SnackVO snack);
	SnackVO selectSnack(int snackNo);
	List<SnackVO> selectAllSnacks();
	boolean updateSnack(SnackVO newSnack);
	boolean deleteSnack(int SnackNO);
}
  