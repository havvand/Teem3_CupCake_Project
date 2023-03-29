package dat.backend.model.persistence;

import dat.backend.model.entities.CupCake;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CupCakePickerMapper {
    static Map<String, CupCake> cupCakeMapTop = new HashMap<>();
    static Map<String, CupCake> cupCakeMapBottom = new HashMap<>();

    static Map<String, CupCake> PickTop(ConnectionPool connectionPool) throws SQLException
    {
        CupCake cupCake;
        Logger.getLogger("web").log(Level.INFO, "");

        //String sql = "SELECT * FROM toppingtype WHERE flavour = ?";
        String sql = "SELECT toppingtype.typeId, toppingtype.flavour, toppingtype.price FROM toppingtype";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                //ps.setString(1, topping);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String flavour = (rs.getString("flavour"));
                    int price = (rs.getInt("price"));
                    int typeId = (rs.getInt("typeId"));
                    //result = topping;
                    cupCake = new CupCake(typeId, flavour, price);
                    cupCakeMapTop.put(flavour, cupCake);
                }
            } catch (SQLException ex) {
                throw new SQLException("No such topping!", ex);
            }
            return cupCakeMapTop;
        }
    }

    static Map<String, CupCake> PickBottom(ConnectionPool connectionPool) throws DatabaseException
    {
        CupCake cupCake;
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "SELECT bottomtype.typeId, bottomtype.flavour, bottomtype.price FROM bottomtype";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    String flavour = (rs.getString("flavour"));
                    int price = (rs.getInt("price"));
                    int typeId = (rs.getInt("typeId"));
                    cupCake = new CupCake(typeId, flavour, price);
                    cupCakeMapBottom.put(flavour, cupCake);
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "No such bottom!");
        }
        return cupCakeMapBottom;
    }
}
