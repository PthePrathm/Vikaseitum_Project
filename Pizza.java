package PizzaFactory;

public class Pizza {
    private String pizzaName;
    private String pizzaSize;
    private double pizzaPrice;

    public Pizza(String pizzaName, String pizzaSize, double pizzaPrice) {
        this.pizzaName = pizzaName;
        this.pizzaSize = pizzaSize;
        this.pizzaPrice = pizzaPrice;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public void setPizzaPrice(double pizzaPrice) {
        this.pizzaPrice = pizzaPrice;
    }

    @Override
    public String toString() {
        return getPizzaName()+"\t"+getPizzaSize()+"\t"+getPizzaPrice();
    }
}
