package snack;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapSnackDAO implements SnackDAO {

    protected Map<Integer, SnackVO> snackDB = new HashMap<>();
    protected int snackSeq = 111;

    @Override
    public boolean insertSnack(SnackVO snack) {
        snack.setSnackNo(snackSeq++);
        snack.setRegdate(new Date());
        snackDB.put(snack.getSnackNo(), snack);
        return true;
    }

    @Override
    public SnackVO selectSnack(int snackNo) {
        return snackDB.get(snackNo);
    }

    @Override
    public List<SnackVO> selectAllSnacks() {
        return new ArrayList<>(snackDB.values());
    }

    @Override
    public boolean updateSnack(SnackVO newSnack) {
        snackDB.put(newSnack.getSnackNo(), newSnack);
        return true;
    }

    @Override
    public boolean deleteSnack(int snackNo) {
        return snackDB.remove(snackNo) != null;
    }
}
