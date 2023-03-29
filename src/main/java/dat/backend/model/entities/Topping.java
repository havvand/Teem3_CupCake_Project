package dat.backend.model.entities;

public class Topping
{
    private String flavour;
    private int price;
    private int typeId;

    public Topping(int typeId, String flavour, int price)
    {
        this.flavour = flavour;
        this.price = price;
        this.typeId = typeId;
    }
    public String getFlavour()
    {
        return this.flavour;
    }

    public int getPrice() {
        return price;
    }


    public int getTypeId() {
        return typeId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String toString()
    {
        return this.flavour + " " +  this.price;
    }
}
