package PizzaFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Toppings {
    Map<String,Double> vegToppings=new LinkedHashMap<>();
    Map<String,Double> nonVegToppings=new LinkedHashMap<>();
    Map<String,Integer> vegToppingsStock=new LinkedHashMap<>();
    Map<String,Integer> nonVegToppingsStock=new LinkedHashMap<>();
    void addNewToppings(String toppingsType,String toppingsName,double toppingprice,int toppingStockQty);
    void viewVegToppings();
    void viewNonVegToppings();
}
