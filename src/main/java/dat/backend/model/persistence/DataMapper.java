package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataMapper {
    private static ArrayList<Order> orderHistory = new ArrayList<>();

    static ArrayList<Order> showOrderHistory(ConnectionPool connectionPool) {
        Order order = null;

        String sql = "SELECT * FROM orderhistory";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("orderId");
                    int price = rs.getInt("price");
                    int userId = rs.getInt("userId");
                    String name = rs.getString("name");
                    order = new Order(orderId, price, userId, name);
                    orderHistory.add(order);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orderHistory;
    }

    static ArrayList<Order> deleteOrderHistory(int orderId, int price, int userId, String name, ConnectionPool connectionPool) {
        Order order = new Order(orderId, price, userId, name);
        ArrayList<Order> orderHistory = showOrderHistory(connectionPool);
        orderHistory.remove(order);
        String sql = "DELETE FROM orderhistory WHERE 'orderId' = orderId";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orderHistory;
    }
}
