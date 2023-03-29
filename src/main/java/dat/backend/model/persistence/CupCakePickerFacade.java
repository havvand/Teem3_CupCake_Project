package dat.backend.model.persistence;

import dat.backend.model.entities.CupCake;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.Map;

public class CupCakePickerFacade {
    public static Map<String, CupCake> PickTop(ConnectionPool connectionPool) throws SQLException {
        return CupCakePickerMapper.PickTop(connectionPool);
    }

    public static Map<String, CupCake> PickBottom(ConnectionPool connectionPool) throws DatabaseException
    {
        return CupCakePickerMapper.PickBottom( connectionPool);
    }
}
