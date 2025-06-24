package order;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class OrderVO {
    private int orderId;                 // 주문 번호
    private String userId;               // 주문자 ID
    private Map<Integer, Integer> cart = new HashMap<>();  // 간식번호:수량 맵

    // 생성자
    public OrderVO(int orderId, String userId, Map<Integer, Integer> cart) {
        this.orderId = orderId;
        this.userId = userId;
        this.cart = cart;
    }

    // getter/setter
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getUserId() {
        return userId;
    }
    public Map<Integer, Integer> getCart() {
        return cart;
    }

    // OrderVO 객체를 문자열로 변환 (파일 저장용)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(orderId);
        sb.append("|");
        sb.append(userId);
        sb.append("|");

        if (cart.isEmpty()) {
            sb.append("");
        } else {
            StringJoiner joiner = new StringJoiner(",");
            for (Map.Entry<Integer, Integer> entry : cart.entrySet()) {
                Integer snackNo = entry.getKey();
                Integer quantity = entry.getValue();
                String pair = snackNo + ":" + quantity;
                joiner.add(pair);
            }
            String cartString = joiner.toString();
            sb.append(cartString);
        }

        return sb.toString();
    }

    // 문자열을 OrderVO 객체로 변환 (파일 읽기용)
    public static OrderVO fromString(String s) {
        String[] parts = s.split("\\|");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid order string format");
        }

        int orderId;
        try {
            orderId = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid orderId format");
        }

        String userId = parts[1];
        Map<Integer, Integer> cart = new HashMap<>();

        String cartPart = parts[2];
        if (!cartPart.isEmpty()) {
            String[] items = cartPart.split(",");
            for (String item : items) {
                String[] kv = item.split(":");
                if (kv.length != 2) {
                    continue; // 무시하거나 예외 던질 수도 있음
                }
                try {
                    Integer snackNo = Integer.parseInt(kv[0]);
                    Integer quantity = Integer.parseInt(kv[1]);
                    cart.put(snackNo, quantity);
                } catch (NumberFormatException e) {
                    // 숫자 변환 실패 시 무시
                    continue;
                }
            }
        }

        return new OrderVO(orderId, userId, cart);
    }
}
