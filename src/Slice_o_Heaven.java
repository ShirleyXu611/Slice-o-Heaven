public class Slice_o_Heaven {
    public String storeName;
    public String storeAddress;
    public String StoreEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public double pizzaPrice;
    public String sides;
    public String drinks;
    private String orderID;
    private double orderTotal;
    public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;
    private String cardNumber;
    private int cardLength;
    private int firstCardDigit;
    private String blacklistedNumber;
    private int lastFourDigits;
    public String cardNumberToDisplay;

    public void processCardPayment(String cardNumber,String expiryDate,int cvv){
        this.cardNumber=cardNumber;
        cardLength=cardNumber.length();
        if(cardLength==14){
            System.out.println("Card accepted.");
        }else{
            System.out.println("Invalid cards.");
        }
        String cN1=cardNumber.substring(0,1);
        firstCardDigit=Integer.parseInt(cN1);
        if(cardNumber.equals(blacklistedNumber)){
            System.out.println("Card is blacklisted.Please use another card.");
        
        }
        String cN2=cardNumber.substring(10,14);
        lastFourDigits=Integer.parseInt(cN2);
        StringBuilder sb = new StringBuilder(cardNumber);
        sb.replace(1, 10, "*********");
        String cardNumberToDisplay = sb.toString(); 
        System.out.println(cardNumberToDisplay);
    }

    public void specialOfTheDay(String pizzaOfTheDay,String sidesOfTheDay,String specialPrice){
        System.out.println("The special pizza of the day is:"+pizzaOfTheDay);
        System.out.println("The special sides of the day is:"+sidesOfTheDay);
        System.out.println("The special price of the day is:"+specialPrice);
    }

    public Slice_o_Heaven(){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
        this.drinks = "";
    }

    public Slice_o_Heaven(String orderID,String pizzaIngredients,double orderTotal,String sides,String drinks){
        this.orderID = DEF_ORDER_ID;
        this.pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        this.orderTotal = DEF_ORDER_TOTAL;
        this.sides = "";
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