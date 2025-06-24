package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCartDAO implements CartDAO {

    Map<Integer, CartItemVO> cartDB = new HashMap<>();

    @Override
    public boolean insertCartItem(CartItemVO item) {
        boolean isNew = !cartDB.containsKey(item.getSnackNo());
        cartDB.put(item.getSnackNo(), item);
        return isNew;
    }

    @Override
    public CartItemVO selectCartItem(int snackNo) {
        return cartDB.get(snackNo);
    }

    @Override
    public List<CartItemVO> selectAllCartItem() {
        return new ArrayList<>(cartDB.values());
    }

    @Override
    public boolean deleteCartItem(int snackNo) {
        return cartDB.remove(snackNo) != null;
    }

    @Override
    public boolean clear() {
        cartDB.clear();
        return true;
    }
}
