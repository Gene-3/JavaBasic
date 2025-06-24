package order;

import java.util.Date;
import java.util.List;
import snack.SnackService;
import snack.SnackVO;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private SnackService snackService;

    private final int COMPLETE = 10;

    public OrderServiceImpl(OrderDAO orderDAO, SnackService snackService) {
        this.orderDAO = orderDAO;
        this.snackService = snackService;
    }

    @Override
    public boolean orderItems(OrderVO order) {
        order.setOrderDate(new Date());
        order.setStatus(COMPLETE);
        order.setDeliverDate(new Date());

        for (OrderItemVO item : order.getOrderItemList()) {
            int snackNo = item.getSnackNo();
            SnackVO snack = snackService.detailSnackInfo(snackNo);
            if (snack == null) return false;

            int newInstock = snack.getInstock() - item.getQuantity();
            if (newInstock >= 0) {
                snackService.updateSnackInstock(snackNo, newInstock);
            } else {
                return false;
            }
        }

        return orderDAO.insertOrder(order);
    }

    @Override
    public List<OrderVO> listMyOrder(String memberId) {
        return orderDAO.selectOrdersOfMember(memberId);
    }

    @Override
    public List<OrderVO> listAllOrder() {
        return orderDAO.selectAllOrder();
    }
}
