package order;

import java.util.List;

public interface OrderService {
    boolean orderItems(OrderVO order);
    List<OrderVO> listMyOrder(String memberId);
    List<OrderVO> listAllOrder();
}
