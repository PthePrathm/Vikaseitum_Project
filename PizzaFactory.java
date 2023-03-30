package PizzaFactory;

import java.util.Scanner;

public class PizzaFactory {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        PizzaService ps=new PizzaService();

        ps.addNewPizzaToInventory("Veg","DELUXE_VEGGIE","REGULAR",150);
        ps.addNewPizzaToInventory("Veg","DELUXE_VEGGIE","MEDIUM",200);
        ps.addNewPizzaToInventory("Veg","DELUXE_VEGGIE","LARGE",325);
        ps.addNewPizzaToInventory("Veg","CHEESE_AND_CORN","REGULAR",175);
        ps.addNewPizzaToInventory("Veg","CHEESE_AND_CORN","MEDIUM",375);
        ps.addNewPizzaToInventory("Veg","CHEESE_AND_CORN","LARGE",475);
        ps.addNewPizzaToInventory("Veg","PANEER_TIKKA","REGULAR",160);
        ps.addNewPizzaToInventory("Veg","PANEER_TIKKA","MEDIUM",290);
        ps.addNewPizzaToInventory("Veg","PANEER_TIKKA","LARGE",340);
        ps.addNewPizzaToInventory("NON VEG","NON_VEG_SUPREME","REGULAR",190);
        ps.addNewPizzaToInventory("NON VEG","NON_VEG_SUPREME","MEDIUM",325);
        ps.addNewPizzaToInventory("NON VEG","NON_VEG_SUPREME","LARGE",425);
        ps.addNewPizzaToInventory("NON VEG","CHICKEN_TIKKA","REGULAR",210);
        ps.addNewPizzaToInventory("NON VEG","CHICKEN_TIKKA","MEDIUM",370);
        ps.addNewPizzaToInventory("NON VEG","CHICKEN_TIKKA","LARGE",500);
        ps.addNewPizzaToInventory("NON VEG","PANEER_BARBEQUE_CHICKEN","REGULAR",220);
        ps.addNewPizzaToInventory("NON VEG","PANEER_BARBEQUE_CHICKEN","MEDIUM",380);
        ps.addNewPizzaToInventory("NON VEG","PANEER_BARBEQUE_CHICKEN","LARGE",525);

        ps.addNewToppings("VEG","Black_Olive",20,100);
        ps.addNewToppings("VEG","CAPSICUM",25,100);
        ps.addNewToppings("VEG","PANEER",35,100);
        ps.addNewToppings("VEG","MUSHROOM",30,100);
        ps.addNewToppings("VEG","FRESH_TOMATO",10,100);
        ps.addNewToppings("NON VEG","EXTRA_CHEESE",35,100);
        ps.addNewToppings("NON VEG","CHICKEN_TIKKA",35,100);
        ps.addNewToppings("NON VEG","BARBEQUE_CHICKEN",45,100);
        ps.addNewToppings("NON VEG","GRILLED_CHICKEN",40,100);

        ps.addNewSides("Cold_Drink",55,100);
        ps.addNewSides("Mousse_Cake",90,100);

        boolean status=true;
        while(status){
            System.out.println("Select user\n1:Admin\n2:Customer");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    boolean Continue=true;
                    while(Continue){
                        System.out.println("Choose option\n" +
                                "1:Add new Pizza\n" +
                                "2:Add new toppings\n" +
                                "3:Add new sides\n" +
                                "4:Change Price\n" +
                                "5:Exit to main menu");
                        int operation= sc.nextInt();
                        switch (operation){
                            case 1:
                                System.out.println("enter pizza type veg or non-veg\n");
                                String pizzaType=sc.next();
                                System.out.println("enter pizza name");
                                String pizzaName=sc.nextLine();
                                System.out.println("enter pizza size REGULAR,MEDIUM,LARGE");
                                String pizzaSize=sc.next();
                                System.out.println("enter price for the pizza");
                                double pizzaPrice=sc.nextDouble();

                                ps.addNewPizzaToInventory(pizzaType,pizzaName,pizzaSize,pizzaPrice);
                                break;

                            case 2:
                                System.out.println("enter type of the toppings VEG or NON VEG");
                                String toppingType=sc.next();
                                System.out.println("enter name for the toppings");
                                String toppingName=sc.next();
                                System.out.println("enter price for the toppings");
                                double toppingPrice= sc.nextDouble();
                                System.out.println("enter quantity for the toppings");
                                int toppingQty= sc.nextInt();

                                ps.addNewToppings(toppingType,toppingName,toppingPrice,toppingQty);
                                break;

                            case 3:
                                System.out.println("Enter side name");
                                String sideName=sc.nextLine();
                                System.out.println("Enter side price");
                                double sidePrice= sc.nextDouble();
                                System.out.println("Enter stock Quantity");
                                int sideQty= sc.nextInt();

                                ps.addNewSides(sideName,sidePrice,sideQty);
                                break;

                            case 4:
                                System.out.println("Price is changed");
                                break;
                            case 5:
                                Continue=false;
                                break;
                            default:
                                System.out.println("Invalid ooption selected");
                                Continue=false;
                                break;
                        }
                    }
                case 2:
                    boolean WantToContinue=true;
                    while(WantToContinue){
                        System.out.println("Select mode of ooperation\n" +
                                "1:View Menu\n" +
                                "2:Customize order\n" +
                                "3:Confirm and Proceed with order");
                        int operation= sc.nextInt();
                        switch (operation){
                            case 1:
                                ps.viewVegPizza();
                                ps.viewNonVegPizza();
                                ps.viewVegToppings();
                                ps.viewNonVegToppings();
                                ps.viewCrust();
                                ps.viewSides();
                                break;

                            case 2:
                                System.out.println("Select 1:Veg \n 2:Non-veg Pizza");
                                int ptype= sc.nextInt();
                                if(ptype==1){
                                    String toppingName;
                                    String side;
                                    ps.viewVegPizza();
                                    System.out.println("ENter pizza name");
                                    String pizzaName=sc.nextLine();
                                    System.out.println("Enter quantity");
                                    int pizzaQty= sc.nextInt();

                                    ps.viewCrust();
                                    System.out.println("Enter crust type");
                                    String crustType= sc.nextLine();
                                    ps.viewSize();
                                    System.out.println("Enter size for pizza");
                                    String size= sc.next();
                                    System.out.println("1:Want to add some toppings\n2:No Toppings");
                                    int tChoice= sc.nextInt();
                                    if (tChoice==1){
                                        ps.viewVegToppings();
                                        System.out.println("Write topping name");
                                        toppingName=sc.nextLine();
                                    }else
                                        toppingName="";
                                    System.out.println("1:Want to add Sides\n2:No Sides");
                                    int sChoice= sc.nextInt();
                                    if (sChoice==1){
                                        ps.viewSides();
                                        System.out.println("Enter side name");
                                        side= sc.nextLine();

                                    }else
                                        side="";

                                    Order order=new Order(pizzaName,pizzaQty,toppingName,crustType,side,size,"VEG");
                                    ps.placeOrder(order);
                                    PizzaService.calculateBill();
                                } else if (ptype==2) {
                                    String toppingName;
                                    String side;
                                    ps.viewNonVegPizza();
                                    System.out.println("Enter pizza name");
                                    String name= sc.nextLine();
                                    System.out.println("Enter pizza qty");
                                    int qty= sc.nextInt();

                                    ps.viewCrust();
                                    System.out.println("Enter type of crust");
                                    String crust= sc.nextLine();

                                    ps.viewSize();
                                    System.out.println("Enter size of pizza");
                                    String size=sc.next();

                                    System.out.println("1:Want to add some toppings\n2:No Toppings");
                                    int tChoice= sc.nextInt();
                                    if (tChoice==1){
                                        ps.viewNonVegToppings();
                                        System.out.println("Write topping name");
                                        toppingName=sc.nextLine();
                                    }else
                                        toppingName="";
                                    System.out.println("1:Want to add Sides\n2:No Sides");
                                    int sChoice= sc.nextInt();
                                    if (sChoice==1){
                                        ps.viewSides();
                                        System.out.println("Enter side name");
                                        side= sc.nextLine();

                                    }else
                                        side="";

                                    Order order=new Order(name,qty,toppingName,crust,side,size,"NON_VEG");
                                    ps.placeOrder(order);
                                    PizzaService.calculateBill();
                                }
                                break;
                            case 3:
                                System.out.println("Here are you order details please confirm");
                                ps.viewOrder();

                                System.out.println("1:Want to continue with the order\n2:Cancle");
                                int oChoice= sc.nextInt();
                                if (oChoice==1){
                                    ps.viewOrder();
                                }else {
                                    System.out.println("Customer can not cancle order");
                                }
                            default:
                                WantToContinue=false;
                                break;
                        }
                    }
            }
        }
    }
}
