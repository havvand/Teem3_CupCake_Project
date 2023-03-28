package dat.backend.model.persistence;

import dat.backend.model.entities.Order;

import java.util.ArrayList;

public class DataFacade {
    public static ArrayList<Order> showOrderHistory(ConnectionPool connectionPool) {
        return DataMapper.showOrderHistory(connectionPool);
    }
    public static boolean deleteOrderHistory(int orderId, ConnectionPool connectionPool) {
        return DataMapper.deleteOrderHistory(orderId, connectionPool);
    }
}
