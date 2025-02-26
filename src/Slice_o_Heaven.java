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
    public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;

    public Slice_o_Heaven(){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = 0;
        this.drinks = "";
    }

    public Slice_o_Heaven(String orderID,String pizzaIngredients,double orderTotal,int sides,String drinks){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = 0;
        this.drinks = "";
    }

    public String getOrderID(){
        return orderID;
    }
    public void setOrderID(String orderID){
        this.orderID=orderID;
    }
    public double getOrderTotal(){
        return orderTotal;
    }
    public void setOrderTotal(double orderTotal){
        this.orderTotal=orderTotal;
    }

    public void takeOrder() {
        System.out.println("Order accepted!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            makePizza();
            System.out.println("Order is ready for pickup!");
        }
        makePizza();
        System.out.println("Order is ready for pickup!");
        printRecipt();
    }

    private void makePizza() {
        System.out.println("Pizza start making!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("The pizza is finished!");
        }
        System.out.println("The pizza is finished!");
    }

    private void printRecipt() {
        System.out.println("********RECEIPT********");
        System.out.println("Order ID:" + orderID);
        System.out.println("Pizza Ingredients:"+pizzaIngredients);
        System.out.println("Order Total:" + orderTotal);
    }
}
