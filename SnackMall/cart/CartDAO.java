package cart;

import java.util.List;

public interface CartDAO {
	boolean insertCartItem(CartItemVO item);
	CartItemVO selectCartItem(int snackNo);
	List<CartItemVO> selectAllCartItem();
	boolean deleteCartItem(int snackNo);
	boolean clear();
}
