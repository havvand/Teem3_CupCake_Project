package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.ArrayList;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String name, String password, ConnectionPool connectionPool) throws DatabaseException
    {
        return UserMapper.createUser(username, name, password, connectionPool);
    }

    public static ArrayList<User> showUserHistory(ConnectionPool connectionPool) {
        return UserMapper.showUserHistory(connectionPool);
    }

    public static ArrayList<User> showUsers(ConnectionPool connectionPool) {
        return UserMapper.showUsers(connectionPool);
    }

    public static boolean insertMoney(int userId, int balance, ConnectionPool connectionPool) {
        return UserMapper.insertMoney(userId, balance, connectionPool);
    }

}
