package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupCakePickerFacade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class ShoppingCart
{
    ConnectionPool connectionPool;
    Map<String, CupCakes> CupCakesTop;
    Map<String, CupCakes> CupCakesBottom;

    private String id = "";
    private static ArrayList<String> orders = new ArrayList<>();

    public ShoppingCart(String id)
    {
        this.id = id;
    }

    public ArrayList<String> addOrder(String id, int quantity)
    {
        int i = 1;
        while(i <= quantity)
        {
            orders.add(id);
            i++;
        }

        return orders;
    }

    public int getPrice(String idTop, String idBottom, int quantity)
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
        try {
            CupCakesTop = CupCakePickerFacade.PickTop(connectionPool);
            CupCakesBottom = CupCakePickerFacade.PickBottom(connectionPool);
        } catch (DatabaseException | SQLException e) {
            e.printStackTrace();
        }
        int total = CupCakesTop.get(idTop).getPrice() + CupCakesBottom.get(idBottom).getPrice();

        if(quantity > 1)
        {
            total *= quantity;
        }

        return total;
    }

    public void printOrderList()
    {
        System.out.println("PRINTET FROM SHOPPINGCART - LIST OF ORDERS");
        for (String s: orders)
        {
            System.out.println(s);
        }
    }

}
