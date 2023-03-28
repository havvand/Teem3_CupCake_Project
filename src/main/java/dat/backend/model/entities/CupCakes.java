package dat.backend.model.entities;

public class CupCakes
{
    private String flavour;
    private int price;
    private int typeId;

    public CupCakes(int typeId, String flavour, int price)
    {
        this.flavour = flavour;
        this.price = price;
        this.typeId = typeId;
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
