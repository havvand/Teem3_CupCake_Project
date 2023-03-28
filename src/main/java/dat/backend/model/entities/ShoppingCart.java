package dat.backend.model.entities;

import java.util.ArrayList;

public class ShoppingCart
{
    private String id = "";
    private static ArrayList<String> orders = new ArrayList<>();

    public ShoppingCart(String id)
    {
        this.id = id;
    }

    public ArrayList<String> addOrder(String id)
    {
        orders.add(id);
        return orders;
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
