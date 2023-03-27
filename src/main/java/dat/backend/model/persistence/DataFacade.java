package dat.backend.model.persistence;

import dat.backend.model.entities.Order;

import java.util.ArrayList;

public class DataFacade {
    public static ArrayList<Order> showOrderHistory(ConnectionPool connectionPool) {
        return DataMapper.showOrderHistory(connectionPool);
    }
    public static ArrayList<Order> deleteOrderHistory(int orderId, int price, int userId, String name, ConnectionPool connectionPool) {
        return DataMapper.deleteOrderHistory(orderId, price, userId, name, connectionPool);
    }
}
