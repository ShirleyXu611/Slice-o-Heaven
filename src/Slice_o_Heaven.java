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
    public long cardnumber;
    public final String DEF_ORDER_ID = "DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS = "Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL = 15.00;
    public final String blackListedNumber = "12345678901234";
    private String cardNumber;
    private int firstCardDigit;
    private String blacklistedNumber;
    private int lastFourDigits;
    public String cardNumberToDisplay;
    public String ingredient;
    public String size;
    public String sidedish;
    public String drink;
    public String birthdate;
    public String expiryDate;
    public String strCardNumber;
    public String extraCheese;
    public int ingChoice1 = 0;
    public int ingChoice2 = 0;
    public int ingChoice3 = 0;
    public int sizechoice = 0;
    public int sideDishChoice = 0;
    public int drinkChoice = 0;
    public int age = 0;
    public int cardLength =0 ;
    public LocalDate date,now,expirydate;
    public boolean Discount = false;
    public String ing1;
    public String ing2;
    public String ing3;
    Scanner input = new Scanner(System.in);

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


    private String convertToIngredient(int choice){
        switch(choice){
            case 1:
                ingredient = "Mushroom";
                break;
            case 2:
                ingredient = "Paprika";
                break;
            case 3:
                ingredient = "Sun-dried tomatoes";
                break;
            case 4:
                ingredient = "Chicken";
                break;
            case 5:
                ingredient ="Pineapple";
                break;
        }
        return ingredient;
    }


    private String convertToSize(int choice){
        switch(choice){
            case 1:
                size = "Large";
                break;
            case 2:
                size = "Medium";
                break;
            case 3:
                size = "Small";
                break;
        }
        return size;
    }


    private String convertToSideDish(int choice){
        switch(choice){
            case 1:
                sidedish = "Calzone";
                break;
            case 2:
                sidedish = "Garlic bread";
                break;
            case 3:
                sidedish = "Chicken puff";
                break;
            case 4:
                sidedish = "Muffin";
                break;
            case 5:
                sidedish = "Nothing for me";
        }
        return sidedish;
    }


    private String convertToDrinks(int choice){
        switch(choice){
            case 1:
                drink = "Coca cola";
                break;
            case 2:
                drink = "Cold coffee";
                break;
            case 3:
                drink = "Cocoa Drink";
                break;
            case 4:
                drink = "No drinks for me";
                break;
        }
        return drink;
    }


    public void takeOrder(){
        do{
            System.out.println("Please pick any three of the following ingredients:\n1.Mushroom\n2.Paprika\n3.Sun-dried tomatoes\n4.Chicken\n5.Pineapple\nEnter any three choices(1,2,3,...)separated with spaces:");
            ingChoice1 = input.nextInt();
            ingChoice2 = input.nextInt();
            ingChoice3 = input.nextInt();
            if(ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5){
                System.out.println("Invalid choice(s).Please pick only from the given list:\n");
            }
        }while(ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5);
        ing1 = convertToIngredient(ingChoice1);
        ing2 = convertToIngredient(ingChoice2);
        ing3 = convertToIngredient(ingChoice3);
        System.out.println("You've chosen "+ing1+","+ing2+" and "+ing3+"\n");
        

        do{
            System.out.println("What size should your pizza be?\n1.Large\n2.Medium\n3.Small\nEnter only one choice(1,2,or3):");
            sizechoice = input.nextInt();
            if(sizechoice<1||sizechoice>3){
                System.out.println("Invalid choice(s).Please pick only from the given list:\n");
            }
        }while(sizechoice<1||sizechoice>3);
        String pizzaSize = convertToSize(sizechoice);
        System.out.println("You've chosen "+pizzaSize+"\n");


        input.nextLine();
        System.out.println("Do your want extra cheese(Y/N):");
        extraCheese = input.nextLine();


        do{
            System.out.println("Following are the side dish that go well with your pizza:\n1. Calzone\n2. Garlic bread\n3. Chicken puff\n4. Muffin\n5. Nothing for me\nWhat would you like? Pick one (1, 2, 3,…):");
            sideDishChoice = input.nextInt();
            if(sideDishChoice<1||sideDishChoice>5){
                System.out.println("Invalid choice(s).Please pick only from the given list:\n");
            }
        }while(sideDishChoice<1||sideDishChoice>5);
        String sideDish = convertToSideDish(sideDishChoice);
        System.out.println("You've chosen "+sideDish+"\n");


        do{
            System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\n1. Coca Cola\n2. Cold coffee\n3. Cocoa Drink\n4. No drinks for me\nEnter your choice:");
            drinkChoice = input.nextInt();
            if(drinkChoice<1||drinkChoice>4){
                System.out.println("Invalid choice(s).Please pick only from the given list:\n");
            }
        }while(drinkChoice<1||drinkChoice>4);
        drinks = convertToDrinks(drinkChoice);
        System.out.println("You've chosen "+drinks);
        input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order?(Y/N):");
        String wantDiscount = input.nextLine();
        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }


        System.out.println("Order accepted!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            makePizza();
            System.out.println("Order is ready for pickup!");
        }
        makePizza();
        System.out.println("Order is ready for pickup!");
        toString();
        input.close();
    }


    public void isItYourBirthday(){
        do{
            System.out.println("Enter your birthdate(YYYY-MM-DD):");
            birthdate = input.nextLine();
            int year1 = Integer.parseInt(birthdate.substring(0,4));
            int month1 = Integer.parseInt(birthdate.substring(5,7));
            int day1 = Integer.parseInt(birthdate.substring(8,10));
            date = LocalDate.of(year1, month1, day1);
            now = LocalDate.now();
            Period diff= Period.between(date,now);
            age = diff.getYears();
            if(age<5||age>120){
                System.out.println("Invalid date.You are either too young or too dead to order.Please enter a valid date:\n");
            }
        }while(age<5||age>120);
        if (age<18&&date.getDayOfYear()==now.getDayOfYear()){
            System.out.println("Congradulations!You pay only half the price for your order.");
            Discount = true;
            makeCardPayment();
            input.nextLine();
        }else{
            System.out.println("Too bad!You do not meet the conditions to get our 50% discount.");
            makeCardPayment();
        }
    }


    public void makeCardPayment(){
        now = LocalDate.now();
        do{
            System.out.println("Enter your card number:");
            cardnumber = input.nextLong();
            input.nextLine();
            System.out.println("Enter your card's expiry date(YYYY-MM-DD):");
            expiryDate = input.nextLine();
            int year2 = Integer.parseInt(expiryDate.substring(0,4));
            int month2 = Integer.parseInt(expiryDate.substring(5,7));
            int day2 = Integer.parseInt(expiryDate.substring(8,10));
            expirydate = LocalDate.of(year2,month2,day2);
            if(now.isAfter(expirydate)){
                System.out.println("Your card is inavailble");
                System.out.println("please enter another card");
            }
        }while(now.isAfter(expirydate));
        System.out.println("please enter your cvv：");
        String cvv = input.nextLine();
        processCardPayment(cardnumber,expiryDate,cvv);
    }


    public void processCardPayment(long cardnumber,String expiryString,String cvv){
        strCardNumber = Long.toString(cardnumber);
        cardNumber=strCardNumber;
        cardLength=strCardNumber.length();
        while(cardLength!=14||strCardNumber.equals(blackListedNumber)){
            System.out.println("Invalid cards.");
            System.out.println("Enter your card number again:");
            strCardNumber=input.nextLine();
            cardLength=strCardNumber.length();
        }
        if(cardLength==14&&!(strCardNumber.equals(blackListedNumber))){
            System.out.println("Card accepted.");
        }
        String cN1=strCardNumber.substring(0,1);
        firstCardDigit=Integer.parseInt(cN1);
        String cN2=strCardNumber.substring(10,14);
        lastFourDigits=Integer.parseInt(cN2);
        StringBuilder sb = new StringBuilder(strCardNumber);
        sb.replace(1, 10, "*********");
        cardNumberToDisplay = sb.toString(); 
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


    public String toString(){
        StringBuilder receipt=new StringBuilder();
        receipt.append("********RECEIPT********");
        receipt.append("\nOrder ID:" + orderID);
        receipt.append("\nCard Number:"+cardNumberToDisplay);
        receipt.append("\nPizza Ingredients:"+ing1+" "+ing2+" "+ing3);
        receipt.append("\nExtra Cheese:"+extraCheese);
        receipt.append("\nSide Dish:"+sidedish);
        receipt.append("\nDrinks:"+drinks);
        if(Discount==true){
            receipt.append("\nOrder Total:"+orderTotal*0.5);
        }else{
            receipt.append("\nOrder Total:"+orderTotal);
        }
        return receipt.toString();
    }
 }
