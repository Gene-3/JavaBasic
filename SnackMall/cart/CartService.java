package cart;

import java.util.List;

public interface CartService {
	boolean addItem2Cart(CartItemVO item);
	CartItemVO getCartItemInfo(int snackNo);
	List<CartItemVO> listCartItems();
	boolean isCartEmpty();
	boolean removeCartItem(int snackNo);
	boolean clearCart();
}
