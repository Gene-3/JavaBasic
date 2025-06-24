package order;

import java.io.*;
import java.util.*;

public class ObjFileHashMapOrderDAO implements OrderDAO, FileOrderDB {

    private Map<Integer, OrderVO> orderDB = new HashMap<>();
    private int orderSeq = 111;
    private final String dataFilename = DATA_FILE + ".obj";

    public ObjFileHashMapOrderDAO() {
        loadOrders();
    }

    @Override
    public void loadOrders() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFilename))) {
            orderDB = (Map<Integer, OrderVO>) ois.readObject();
            orderSeq = Collections.max(orderDB.keySet()) + 1;
        } catch (FileNotFoundException e) {
            System.out.println("[주문 정보 DB 로딩] " + dataFilename + "이 없습니다.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveOrders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFilename))) {
            oos.writeObject(orderDB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insertOrder(OrderVO order) {
        order.setOrderNo(orderSeq++);
        orderDB.put(order.getOrderNo(), order);
        saveOrders();
        return true;
    }

    @Override
    public OrderVO selectBook(int orderNo) {
        return orderDB.get(orderNo);
    }

    @Override
    public List<OrderVO> selectOrdersOfMember(String memberId) {
        List<OrderVO> list = new ArrayList<>();
        for (OrderVO order : selectAllOrder()) {
            if (order.getMemberId().equals(memberId)) {
                list.add(order);
            }
        }
        return list;
    }

    @Override
    public List<OrderVO> selectAllOrder() {
        return new ArrayList<>(orderDB.values());
    }
}
