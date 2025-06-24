package order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cart.CartService;
import snack.SnackDAO;
import snack.SnackVO;

public class OrderService {
    private OrderDAO orderDAO;
    private CartService cartService;
    private SnackDAO snackDAO;

    public OrderService(OrderDAO orderDAO, CartService cartService, SnackDAO snackDAO) {
        this.orderDAO = orderDAO;
        this.cartService = cartService;
        this.snackDAO = snackDAO;
    }

    // 주문 처리 메서드
    public String orderSnack(String userId) {
        // 장바구니 아이템 가져오기
        List<CartService.CartItem> cartItems = cartService.getUserCart(userId);
        // 장바구니가 비어있으면 메시지 반환
        if (cartItems == null || cartItems.isEmpty()) {
            return "장바구니가 비어있습니다.";
        }

        // 재고 및 간식 존재 여부 확인
        for (CartService.CartItem item : cartItems) {
            SnackVO snack = snackDAO.selectSnack(item.getSnackNo());
            if (snack == null) {
                return "간식 " + item.getSnackNo() + "가 존재하지 않습니다.";
            }
            if (snack.getStock() < item.getQuantity()) {
                return "간식 " + item.getSnackNo() + " 재고가 부족합니다.";
            }
        }

        // 재고 차감 및 업데이트
        for (CartService.CartItem item : cartItems) {
            SnackVO snack = snackDAO.selectSnack(item.getSnackNo());
            snack.setStock(snack.getStock() - item.getQuantity());
            snackDAO.updateSnack(snack);
        }

        // 주문 정보 생성
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (CartService.CartItem item : cartItems) {
            orderMap.put(item.getSnackNo(), item.getQuantity());
        }

        // 주문 저장
        orderDAO.saveOrder(userId, orderMap);
        // 장바구니 비우기
        cartService.clearCart(userId);
        return "주문이 완료되었습니다.";
    }

    // 주문 내역 조회
    public List<String> listOrders(String userId) {
        return orderDAO.getOrdersByUser(userId);
    }
}
