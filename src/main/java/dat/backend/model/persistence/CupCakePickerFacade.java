package dat.backend.model.persistence;

import dat.backend.model.exceptions.DatabaseException;

public class CupCakePickerFacade
{
    public static String PickTop(String topping, ConnectionPool connectionPool) throws DatabaseException
    {
        return CupCakePickerMapper.PickTop(topping, connectionPool);
    }

    public static String PickBottom(String bottom, ConnectionPool connectionPool) throws DatabaseException
    {
        return CupCakePickerMapper.PickBottom(bottom, connectionPool);
    }
}
