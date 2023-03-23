package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class CupCakePickerMapper
{
    static String PickTop(String topping, ConnectionPool connectionPool) throws DatabaseException
    {
        String result;

        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM toppingtype WHERE flavour = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, topping);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    result = topping;
                } else
                {
                    throw new DatabaseException("Topping FUCK");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "No such topping!");
        }
        return result;
    }

    static String PickBottom(String bottom, ConnectionPool connectionPool) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT * FROM bottomtype WHERE flavour = ?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setString(1, bottom);
                ResultSet rs = ps.executeQuery();
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "No such topping!");
        }
        return bottom;
    }
}
