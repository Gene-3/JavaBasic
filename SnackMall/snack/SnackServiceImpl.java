package snack;

import java.util.List;

public class SnackServiceImpl implements SnackService {

    private SnackDAO snackDAO;

    public SnackServiceImpl(SnackDAO snackDAO) {
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
    public boolean updateSnackPrice(int snackNo, int price) {
        SnackVO snack = snackDAO.selectSnack(snackNo);
        if (snack == null) return false;
        snack.setPrice(price);
        return snackDAO.updateSnack(snack);
    }

    @Override
    public boolean updateSnackInstock(int snackNo, int instock) {
        SnackVO snack = snackDAO.selectSnack(snackNo);
        if (snack == null) return false;
        snack.setInstock(instock);
        return snackDAO.updateSnack(snack);
    }

    @Override
    public boolean removeSnack(int snackNo) {
        return snackDAO.deleteSnack(snackNo);
    }

    @Override
    public SnackVO detailSnackInfo(int snackNo) {
        return snackDAO.selectSnack(snackNo);
    }
}
