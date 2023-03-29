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
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    Map<String, Topping> CupCakesTop = CupCakePickerFacade.PickTop(connectionPool);
    Map<String, Bottom> CupCakesBottom = CupCakePickerFacade.PickBottom(connectionPool);
    static int price = 0;


    private String id = "";
    private static ArrayList<CupCake> orders = new ArrayList<>();

    public ShoppingCart(String id) throws SQLException, DatabaseException {
        this.id = id;
    }

    public ArrayList<CupCake> addOrder(CupCake cupCake)
    {
        int i = 1;
        while(i <= cupCake.getQuantity())
        {
            orders.add(cupCake);
            i++;
        }

        return orders;
    }

    public CupCake makeCupCake(String top, String bottom, int quantity)
    {
        int price = CupCakesTop.get(top).getPrice() + CupCakesBottom.get(bottom).getPrice();
        String name = CupCakesTop.get(top).getFlavour() + "/" + CupCakesBottom.get(bottom).getFlavour();

        /*if(quantity > 1)
        {
            price *= quantity;
        }*/

        return new CupCake(name, CupCakesTop.get(top).getTypeId(), CupCakesBottom.get(bottom).getTypeId(), quantity, price);
    }

    public static int getPrice()
    {

        for (CupCake c: orders)
        {
            price += c.getPrice();
        }

        return price;
    }


}