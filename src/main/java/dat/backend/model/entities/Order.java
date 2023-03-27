package dat.backend.model.entities;

public class Order {
    private int orderId;
    private int price;
    private int userId;
    private String name;

    public Order(int orderId, int price, int userId, String name) {
        this.orderId = orderId;
        this.price = price;
        this.userId = userId;
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
