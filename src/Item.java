public class Item {
    public String name;
    public double price;
    public int quantity;
    public String description;

    public Item(String name, double price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Item() {
        this.name = "";
        this.price = 0.0;
        this.quantity = 0;
        this.description = "";
    }

}
