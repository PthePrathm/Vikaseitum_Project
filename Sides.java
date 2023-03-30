package PizzaFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public interface Sides {
    Map<String, Double> sideSet=new LinkedHashMap<>();
    Map<String, Integer> sideStocks=new LinkedHashMap<>();
    void addNewSides(String sideName,double sidePrice,int sideStockQty);
    void viewSides();
}
