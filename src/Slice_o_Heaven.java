import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

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


    public void takeOrder(){
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter three ingredients for your pizza(use spaces to separate ingreients):");
        String ing1 = input1.next();
        String ing2 = input1.next();
        String ing3 = input1.next();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter size of pizza(Small,Medium,Large):");
        String pizzaSize = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.println("Do your want extra cheese(Y/N):");
        String extraCheese = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.println("Enter one side dish(calzone,Garlic bread,None):");
        String sideDish = input4.nextLine();
        Scanner input5 = new Scanner(System.in);
        System.out.println("Enter drinks(Cold coffee,Coca drink,Coke,None):");
        String drinks = input5.nextLine();
        Scanner input6 = new Scanner(System.in);
        System.out.println("Would you like the chance to pay only half for your order?(Y/N):");
        String wantDiscount = input6.nextLine();
        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }
        input1.close();
        input2.close();
        input3.close();
        input4.close();
        input5.close();
        input6.close();

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


    public void isItYourBirthday(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your birthdate(YYYY-MM-DD):");
        String birthdate = input.nextLine();
        int year = Integer.parseInt(birthdate.substring(0,4));
        int mouth = Integer.parseInt(birthdate.substring(5,7));
        int day = Integer.parseInt(birthdate.substring(8,10));
        LocalDate date = LocalDate.of(year, mouth, day);
        LocalDate now = LocalDate.now();
        Period diff= Period.between(date,now);
        if (diff.getYears()<18&&date.getDayOfYear()==now.getDayOfYear()){
            System.out.println("Congradulations!You pay only half the price for your order.");
        }else{
            System.out.println("Too bad!You do not meet the conditions to get our 50% discount.");
        }
        input.close();
    }


    public void makeCardPayment(){
        Scanner input1 = new Scanner(System.in);
        System.out.println("Enter your card number:");
        Long cardNumber = input1.nextLong();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter your card's expiry date(YYYY-MM):");
        String expiryDate = input2.nextLine();
        Scanner input3 = new Scanner(System.in);
        System.out.println("Enter your card's cvv number(the last three digits of your card number):");
        String cvv = input3.nextLine();
        processCardPayment(cardNumber,expiryDate,cvv);
        input1.close();
        input2.close();
        input3.close();
    }


    public void processCardPayment(long cardNumber,String expiryString,String cvv){
        String strCardNumber = Long.toString(cardNumber);
        this.cardNumber=strCardNumber;
        cardLength=strCardNumber.length();
        if(cardLength==14){
            System.out.println("Card accepted.");
        }else{
            System.out.println("Invalid cards.");
        }
        String cN1=strCardNumber.substring(0,1);
        firstCardDigit=Integer.parseInt(cN1);
        if(strCardNumber.equals(blacklistedNumber)){
            System.out.println("Card is blacklisted.Please use another card.");
        
        }
        String cN2=strCardNumber.substring(10,14);
        lastFourDigits=Integer.parseInt(cN2);
        StringBuilder sb = new StringBuilder(strCardNumber);
        sb.replace(1, 10, "*********");
        String cardNumberToDisplay = sb.toString(); 
        System.out.println(cardNumberToDisplay);
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
        System.out.println("Order Total:" + orderTotal);
    }
}