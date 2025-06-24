package cart;

import java.io.Serializable;

public class CartItemVO implements Serializable {

	private int snackNo;
	private int quantity;
	
	public CartItemVO(int snackNo, int quantity) {
		this.snackNo = snackNo;
		this.quantity = quantity;
	}

	public int getSnackNo() {
		return snackNo;
	}

	public void setSnackNo(int snackNo) {
		this.snackNo = snackNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "[" + snackNo + "번 간식, " + quantity + "개]";
	}
	
}
