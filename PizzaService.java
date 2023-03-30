package PizzaFactory;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PizzaService implements Sides,Toppings{
    static List<Pizza> vegPizza=new ArrayList<>();
    static List<Pizza> nonVegPizza=new ArrayList<>();
    static List<Order> orderList=new ArrayList<>();

    public void addNewPizzaToInventory(String pizzaType,String pizzaName,String pizzaSize,double pizzaPrice){
        Pizza pizza=new Pizza(pizzaName,pizzaSize,pizzaPrice);
        if (pizzaType.equalsIgnoreCase("veg")){
            vegPizza.add(pizza);
        }else
            nonVegPizza.add(pizza);
    }
    public void viewVegPizza(){
        System.out.println("Available Veg Pizza's are\n");
        System.out.println("Pizza Name\t\t Size\t\t Price");
        for (Pizza p:vegPizza){
            System.out.println(p.getPizzaName()+"\t\t"+p.getPizzaSize()+"\t\t" +p.getPizzaPrice());
        }
        System.out.println();
    }
    public void viewNonVegPizza(){
        System.out.println("Available Non-Veg Pizza's are\n");
        System.out.println("Pizza Name\t\t Size\t\t Price");
        for (Pizza p:nonVegPizza){
            System.out.println(p.getPizzaName()+"\t\t"+p.getPizzaSize()+"\t\t" +p.getPizzaPrice());
        }
        System.out.println();
    }
    @Override
    public void addNewSides(String sideName, double sidePrice, int sideStockQty) {
        sideSet.put(sideName,sidePrice);
        sideStocks.put(sideName,sideStockQty);
    }

    @Override
    public void viewSides() {
        System.out.println("Sides are\n");
        Set<Map.Entry<String,Double>> entries=sideSet.entrySet();
        for (Map.Entry<String,Double> e:entries){
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
        System.out.println();
    }

    @Override
    public void addNewToppings(String toppingsType, String toppingsName, double toppingprice, int toppingStockQty) {
        if (toppingsType.equalsIgnoreCase("veg")){
            vegToppings.put(toppingsName,toppingprice);
            vegToppingsStock.put(toppingsName,toppingStockQty);
        }else {
            nonVegToppings.put(toppingsName,toppingprice);
            nonVegToppingsStock.put(toppingsName,toppingStockQty);
        }

    }

    @Override
    public void viewVegToppings() {
        System.out.println("Available Veg Toppings are \n");
        Set<Map.Entry<String,Double>> vegEntries=vegToppings.entrySet();
        for (Map.Entry<String,Double> e:vegEntries){
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
        System.out.println();
    }

    @Override
    public void viewNonVegToppings() {
        System.out.println("Available Non-Veg Toppings are \n");
        Set<Map.Entry<String,Double>> nonVegEntries=nonVegToppings.entrySet();
        for (Map.Entry<String,Double> e:nonVegEntries){
            System.out.println(e.getKey()+"\t"+e.getValue());
        }
        System.out.println();
    }
    public void viewCrust(){
        System.out.println("We offer following types of crust's");
        Crust[] data=Crust.values();
        for (Crust c:data){
            System.out.println(c);
        }
    }
    public void viewSize(){
        System.out.println("Pizza comes in following sizes");
        PizzaSize[] data=PizzaSize.values();
        for (PizzaSize p:data){
            System.out.println(p);
        }
    }
    static double totalBill;
    public static void calculateBill(){
        for (Order o:orderList){
            if (o.getType().equalsIgnoreCase("veg")){
                for (Pizza p:vegPizza){
                    if(o.getPizzaName().equalsIgnoreCase(p.getPizzaName()) && o.getSize().equalsIgnoreCase(p.getPizzaSize())){
                        if (o.getToppings().isEmpty()&&o.getSides().isEmpty()){
                            totalBill=p.getPizzaPrice()*o.getQty();
                        } else if (o.getToppings().isEmpty()) {
                            Set<Map.Entry<String, Integer>> sideStockEntries=sideStocks.entrySet();
                            for (Map.Entry<String,Integer> side:sideStockEntries){
                                if (side.getKey().equalsIgnoreCase(o.getSides())){
                                    if (side.getValue()>=1){
                                        Set<Map.Entry<String,Double>> sidePriceEntries=sideSet.entrySet();
                                        for (Map.Entry<String,Double> sidePrice:sidePriceEntries){
                                            if (sidePrice.getKey().equalsIgnoreCase(o.getSides())){
                                                totalBill=p.getPizzaPrice()*o.getQty()+sidePrice.getValue();
                                            } else if (sidePrice.getKey().equalsIgnoreCase(o.getToppings())&&p.getPizzaSize().equalsIgnoreCase("large")) {
                                                totalBill=p.getPizzaPrice()*o.getQty()+sidePrice.getValue();
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (o.getSides().isEmpty()) {
                            Set<Map.Entry<String,Integer>>vegToppingsStockEntries=vegToppingsStock.entrySet();
                            for (Map.Entry<String,Integer> stock:vegToppingsStockEntries){
                                if (stock.getKey().equalsIgnoreCase(o.getToppings())){
                                    if (stock.getValue()>=1){
                                        Set<Map.Entry<String,Double>>vegToppingEntries=vegToppings.entrySet();
                                        for (Map.Entry<String,Double> veg:vegToppingEntries){
                                            if (veg.getKey().equalsIgnoreCase(o.getToppings())&&p.getPizzaSize().equalsIgnoreCase("large")){
                                                totalBill=p.getPizzaPrice()*o.getQty();
                                            } else if (veg.getKey().equalsIgnoreCase(o.getToppings())) {
                                                totalBill=p.getPizzaPrice()*o.getQty()+veg.getValue();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            System.out.println("Not in stock");
                        }
                    }
                }
            } else if (o.getType().equalsIgnoreCase("non_veg")) {
                for (Pizza p:nonVegPizza){
                    if (o.getPizzaName().equalsIgnoreCase(p.getPizzaName())&&o.getSize().equalsIgnoreCase(p.getPizzaSize())){
                        if (o.getToppings().isEmpty()&&o.getSides().isEmpty()){
                            totalBill=p.getPizzaPrice()*o.getQty();
                        } else if (o.getToppings().isEmpty()) {
                            Set<Map.Entry<String,Integer>>sideStockEntries=sideStocks.entrySet();
                            for (Map.Entry<String,Integer> side:sideStockEntries){
                                if (side.getKey().equalsIgnoreCase(o.getSides())){
                                    if (side.getValue()>=1){
                                        Set<Map.Entry<String,Double>> sidePriceEntries=sideSet.entrySet();
                                        for (Map.Entry<String,Double> sidePrice:sidePriceEntries){
                                            if (sidePrice.getKey().equalsIgnoreCase(o.getToppings())){
                                                totalBill= p.getPizzaPrice()*o.getQty()+sidePrice.getValue();
                                            } else if (sidePrice.getKey().equalsIgnoreCase(o.getToppings())&&p.getPizzaSize().equalsIgnoreCase("large")) {
                                                totalBill=p.getPizzaPrice()*o.getQty()+sidePrice.getValue();
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (o.getSides().isEmpty()) {
                            Set<Map.Entry<String,Integer>>nonVegToppingsStockEntries=sideStocks.entrySet();
                            for (Map.Entry<String,Integer> side:nonVegToppingsStockEntries){
                                if (side.getKey().equalsIgnoreCase(o.getToppings())){
                                    if (side.getValue()>=1){
                                        Set<Map.Entry<String,Double>> nonVegToppingsEntries=nonVegToppings.entrySet();
                                        for (Map.Entry<String,Double> nonVeg:nonVegToppingsEntries){
                                            if (nonVeg.getKey().equalsIgnoreCase(o.getToppings())&& p.getPizzaSize().equalsIgnoreCase("large")){
                                                totalBill= p.getPizzaPrice()*o.getQty();
                                            } else if (nonVeg.getKey().equalsIgnoreCase(o.getToppings())&&p.getPizzaSize().equalsIgnoreCase("large")) {
                                                totalBill=p.getPizzaPrice()*o.getQty()+nonVeg.getValue();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else{
                        System.out.println("out of stock");
                    }
                }

            }
        }
    }
    public void viewOrder(){
        System.out.println("Pizza Type\tPizza name\tQuantity\tCrust\tExtraToppings\tSides\tPrice");
        for (Order o:orderList){
            System.out.println(o.getType()+"\t"+o.getPizzaName()+"\t"+o.getQty()+"\t"+o.getCrust()+"\t"+o.getToppings()+"\t"+o.getSides()+"\t"+PizzaService.totalBill);
        }
    }
    public void placeOrder(Order order){
        if (orderList.isEmpty()){
            orderList.add(order);
        }
        else {
            System.out.println("Order is processing");
        }
    }


}
