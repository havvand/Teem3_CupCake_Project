package dat.backend.model.persistence;

import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper
{
    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        User user = null;

        String sql = "SELECT * FROM userdata WHERE username = ? AND password = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    String role = rs.getString("role");
                    user = new User(username, password, role);
                } else
                {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String username, String name, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String role = "user";
        String sql = "insert into userdata (username, name, password, role, balance) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, username);
                ps.setString(2, name);
                ps.setString(3, password);
                ps.setString(4, role);
                ps.setInt(5, 0);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1)
                {
                    user = new User(username, password, role);
                } else
                {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return user;
    }

    static ArrayList<User> showUserHistory(ConnectionPool connectionPool) {
        User user = null;
        ArrayList<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM userhistory";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int userId = rs.getInt("userId");
                    String username = rs.getString("username");
                    int balance = rs.getInt("balance");
                    int orderId = rs.getInt("orderId");
                    user = new User(userId, username, balance, orderId);
                    allUsers.add(user);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allUsers;
    }
    static ArrayList<User> showUsers(ConnectionPool connectionPool) {
        User user = null;
        ArrayList<User> allUsers = new ArrayList<>();
        String sql = "SELECT userId, username, balance FROM userdata";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int userId = rs.getInt("userId");
                    String username = rs.getString("username");
                    int balance = rs.getInt("balance");
                    user = new User(userId, balance, username);
                    allUsers.add(user);

                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return allUsers;
    }


    static boolean insertMoney(int userId, int balance, ConnectionPool connectionPool)  {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "UPDATE userdata SET balance = (?+balance) WHERE userId = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, balance);
                ps.setInt(2, userId);
                int rowsaffected = ps.executeUpdate();
                if (rowsaffected == 1) {
                    result = true;
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        catch (SQLException exception) {
           exception.printStackTrace();
        }
        return result;
    }


}
