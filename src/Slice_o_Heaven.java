public class Slice_o_Heaven {
    public String storeName;
    public String storeAddress;
    public String StoreEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public int sides;
    public String drinks;
    private String orderID;
    private double orderTotal;

    public void takeOrder(String id,Double total){
        orderID=id;
        orderTotal=total;
        System.out.println("Order accepted!");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            makePizza();
            System.out.println("Order is ready for pickup!");
        }
        makePizza();
        System.out.println("Order is ready for pickup!");
        printRecipt();
    }
    public void makePizza(){
        System.out.println("Pizza start making!");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println("The pizza is finished!");
        }
        System.out.println("The pizza is finished!");
    }
    public void printRecipt(){
        System.out.println("********RECEIPT********");
        System.out.println("Order ID:"+orderID);
        System.out.println("Order Total:"+orderTotal);
    }
}
