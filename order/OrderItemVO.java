package order;

import java.io.Serializable;

public class OrderItemVO implements Serializable {

    private int snackNo;
    private int quantity;
    private int price;

    public OrderItemVO(int snackNo, int quantity, int price) {
        this.snackNo = snackNo;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\t* 스낵번호: " + snackNo + ", 수량: " + quantity + "개, 가격: " + price + "원";
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
