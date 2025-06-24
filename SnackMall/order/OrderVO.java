package order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderVO implements Serializable {

    private int orderNo;
    private String memberId;
    private List<OrderItemVO> orderItemList;
    private int price;
    private String mobile;
    private String address;
    private Date orderDate;
    private int status;
    private Date deliverDate;

    public OrderVO(String memberId, List<OrderItemVO> orderItemList, int price) {
        this.memberId = memberId;
        this.orderItemList = orderItemList;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("주문번호: ").append(orderNo).append(", 회원ID: ").append(memberId)
          .append(", 총금액: ").append(price).append("원");

        if (orderDate != null) {
            sb.append(", 주문일: ").append(orderDate)
              .append(", 상태: ").append(status)
              .append(", 배송일: ").append(deliverDate);
        }

        sb.append("\n배송지: ").append(address).append(" (").append(mobile).append(")\n");

        for (OrderItemVO item : orderItemList) {
            sb.append(item).append("\n");
        }

        return sb.toString();
    }


    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<OrderItemVO> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemVO> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
}
