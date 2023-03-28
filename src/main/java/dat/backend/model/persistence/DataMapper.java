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

    static boolean deleteOrderHistory(int orderId, ConnectionPool connectionPool) {
        boolean result = false;
        String sql = "DELETE FROM orderdata WHERE orderId = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    result = true;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        orderHistory.removeIf(o -> o.getOrderId() == orderId);
        return result;
    }
}
