package cart;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjFileHashMapCartDAO implements FileCartDB, CartDAO {

    private final String dataFilename = "./data/cartDB.obj";

    Map<Integer, CartItemVO> cartDB = new HashMap<>();
    
    public ObjFileHashMapCartDAO() {
        loadCarts();
    }

    @Override
    public boolean insertCartItem(CartItemVO item) {
    	boolean isNew = !cartDB.containsKey(item.getSnackNo());
        cartDB.put(item.getSnackNo(), item);
        if(isNew) saveCarts();
        return isNew;
    }
    @Override
    public boolean deleteCartItem(int snackNo) {
    	boolean result = cartDB.remove(snackNo) != null;
        if (result) saveCarts();
        return result;
    }

    @Override
    public boolean clear() {
        cartDB.clear();
        saveCarts();
        return true;
    }

	@Override
	public void saveCarts() {
		try (
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFilename))
	        ) {
	            oos.writeObject(cartDB);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void loadCarts() {
		try (
	            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFilename))
	        ) {
	            cartDB = (Map<Integer, CartItemVO>) ois.readObject();
	        } catch (FileNotFoundException e) {
	            System.out.println("[DB 로딩] " + dataFilename + " 없음 - 새로 생성");
	            cartDB = new HashMap<>();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	            cartDB = new HashMap<>();
	        }
		
	}

	@Override
    public CartItemVO selectCartItem(int snackNo) {
        return cartDB.get(snackNo);
    }

    @Override
    public List<CartItemVO> selectAllCartItem() {
        return new ArrayList<>(cartDB.values());
    }
}
