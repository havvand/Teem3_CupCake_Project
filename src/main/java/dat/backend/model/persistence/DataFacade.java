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

    public static void writeToOrderData(int price, int userId, ConnectionPool connectionPool) {
        DataMapper.writeToOrderdata(price, userId,connectionPool);
    }
}
