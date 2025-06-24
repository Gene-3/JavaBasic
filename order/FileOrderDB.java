package order;

public interface FileOrderDB {
    String DATA_FILE = "./data/orderDB";
    void saveOrders();
    void loadOrders();
}
