package PizzaFactory;

public class Order {
    private String pizzaName;
    private int qty;
    private String toppings;
    private String crust;
    private String sides;
    private String size;
    private String type;

    public Order(String pizzaName, int qty, String toppings, String crust, String sides, String size, String type) {
        this.pizzaName = pizzaName;
        this.qty = qty;
        this.toppings = toppings;
        this.crust = crust;
        this.sides = sides;
        this.size = size;
        this.type = type;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
