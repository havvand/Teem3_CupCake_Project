package dat.backend.model.entities;

public class CupCake
{
    private String name;
    private int topping, bottom, quantity, price;

    public CupCake(String name, int topping, int bottom, int quantity, int price)
    {
        this.name = name;
        this.topping = topping;
        this.bottom = bottom;
        this.quantity = quantity;
        this.price = price;
    }


    public String getName()
    {
        return this.name;
    }
    public int getTopping() {return topping;}

    public int getBottom() {return bottom;}

    public int getQuantity() {return quantity;}

    public int getPrice()
    {
        return this.price;
    }

    public String toString()
    {
        return this.name + " " + this.price;
    }

}