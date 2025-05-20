package snack;

import java.util.LinkedList;
import java.util.List;

public class ListSnackDAO implements SnackDAO{

	private List<SnackVO> snackList = new LinkedList<SnackVO>();
	private int snackSeq = 111; // 과자번호 1씩 증가
	
	@Override
	public boolean insertSnack(SnackVO snack) {
		snack.setSnackNo(snackSeq++);
		snackList.add(snack);
		return true;
	}

	@Override
	public SnackVO selectSnack(int snackNo) {
		for (SnackVO snack : snackList) {
			if (snack.getSnackNo() == snackNo)
				return snack;
		}
		return null;
	}

	@Override
	public List<SnackVO> selectAllSnacks() {
		return snackList;
	}

	@Override
	public boolean updateSnack(SnackVO newsnack) {
		for (int i = 0; i < snackList.size(); i++) {
			if (snackList.get(i).getSnackNo() == newsnack.getSnackNo()) {
				snackList.set(i, newsnack);
			return true;
		}
	}
		return false;
}

	@Override
	public boolean deleteSnack(int snackNo) {
		
		for (SnackVO snack : snackList) {
		if (snack.getSnackNo() == snackNo) {
			snackList.remove(snack);
			return true;
		    }
		}
		return false;
	}

}