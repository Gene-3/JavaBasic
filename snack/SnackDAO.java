package snack;

import java.util.List;

public interface SnackDAO {
    boolean insertSnack(SnackVO snack);
    SnackVO selectSnackByName(String name);
    List<SnackVO> selectAllSnacks();
    boolean updateSnack(SnackVO snack);
    boolean deleteSnackByName(String name);
}
