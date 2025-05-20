package snack;

import java.util.List;

public class KJSnackService implements SnackService{

	SnackDAO snackDAO;
	public KJSnackService(SnackDAO snackDAO) {
		this.snackDAO = snackDAO;
	}
	@Override
	public boolean registSnack(SnackVO snack) {
		return snackDAO.insertSnack(snack);
	}

	@Override
	public List<SnackVO> listSnacks() {
		
		return snackDAO.selectAllSnacks();
	}

	@Override
	public SnackVO detailSnackInfo(int snackNo) {
		
		return snackDAO.selectSnack(snackNo);
	}

	@Override
	public boolean updateSnackPrice(int snackNo, int price) {
		SnackVO snack = snackDAO.selectSnack(snackNo);
		if(snack != null) {
			snack.setPrice(price);
			snackDAO.updateSnack(snack);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateSnackInstock(int snackNo, int instock) {
		SnackVO snack = snackDAO.selectSnack(snackNo);
		
		if(snack != null) {
			snack.setInstock(instock);
			snackDAO.updateSnack(snack);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeSnack(int snackNo) {
		SnackVO snack = snackDAO.selectSnack(snackNo);
		if (snack != null) {
			snackDAO.deleteSnack(snackNo);
			return true;
		}
		return false;
	}
	@Override
	public List<SnackVO> listSnack() {
		// TODO Auto-generated method stub
		return null;
	}

}