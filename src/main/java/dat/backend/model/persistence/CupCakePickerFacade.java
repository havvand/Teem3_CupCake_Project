package dat.backend.model.persistence;

import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.CupCakes;
import dat.backend.model.entities.Topping;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.Map;

public class CupCakePickerFacade
{
    public static Map<String, Topping> PickTop(ConnectionPool connectionPool) throws SQLException {
        return CupCakePickerMapper.PickTop(connectionPool);
    }

    public static Map<String, Bottom> PickBottom(ConnectionPool connectionPool) throws DatabaseException
    {
        return CupCakePickerMapper.PickBottom( connectionPool);
    }
}
