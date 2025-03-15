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
    public int ingChoice4 = 0;
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
    public int choice = 0;
    private static int orderIndex=0;
    private static double totalorderPrice=0;
    Scanner input = new Scanner(System.in);



    enum PizzaSelection{
        PEPPERONI("Pepperoni", "Lots of pepperoni and extra cheese", 18),
        HAWAIIAN("Hawaiian", "Pineapple, ham, and extra cheese", 22),
        VEGGIE("Veggie", "Green pepper, onion, tomatoes, mushroom, and black olives", 25),
        BBQ_CHICKEN("BBQ Chicken", "Chicken in BBQ sauce, bacon, onion, green pepper, and cheddar cheese", 35),
        EXTRAVAGANZA("Extravaganza", "Pepperoni, ham, Italian sausage, beef, onions, green pepper, mushrooms, black olives, and extra cheese", 45);

        private final String pizzaName;
        private final String pizzaToppings;
        private final int price;

        PizzaSelection(String pizzaName,String pizzaToppings,int price){
            this.pizzaName=pizzaName;
            this.pizzaToppings=pizzaToppings;
            this.price=price;
        }

        public String getPizzaName(){
            return pizzaName;
        }
        public String getPizzaToppings(){
            return pizzaToppings;
        }
        public int getPrice(){
            return price;
        }

        @Override
        public String toString(){
            return pizzaName+"pizza with "+pizzaToppings+",for €"+price;
        }
        }


    enum PizzaToppings{
        HAM("Ham", 2), 
        PEPPERONI("Pepperoni", 2),
        BEEF("Beef", 2),
        CHICKEN("Chicken", 2), 
        SAUSAGE("Sausage", 2),
        PINEAPPLE("Pineapple", 1),
        ONION("Onion", 0.5), 
        TOMATOES("Tomatoes", 0.4), 
        GREEN_PEPPER("Green Pepper", 0.5), 
        BLACK_OLIVES("Black Olives", 0.5), 
        PINACH("Spinach", 0.5), 
        CHEDDAR_CHEESE("Cheddar Cheese", 0.8), 
        MOZZARELLA_CHEESE("Mozzarella Cheese", 0.8), 
        FETA_CHEESE("Feta Cheese", 1), 
        PARMESAN_CHEESE("Parmesan Cheese", 1);

        private final String topping;
        private final double toppingPrice;

        PizzaToppings(String topping,double toppingPrice){
            this.topping=topping;
            this.toppingPrice=toppingPrice;
        }

        public String getTopping(){
            return topping;
        }
        public double getToppingPrice(){
            return toppingPrice;
        }

        @Override
        public String toString(){
            return "toppping: "+topping+"topping price: "+toppingPrice;
        }
    }

    enum PizzaSize{
        LARGE("Large", 10), 
        MEDIUM("Medium", 5),
        SMALL("Small", 0);

        private final String pizzaSize;
        private final int addToPizzaPrice;

        PizzaSize(String pizzaSize,int addToPizzaPrice){
            this.pizzaSize=pizzaSize;
            this.addToPizzaPrice=addToPizzaPrice;
        }

        public String getPizzaSize(){
            return pizzaSize;
        }
        public int getAddToPizzaPrice(){
            return addToPizzaPrice;
        }

        @Override
        public String toString(){
            return "pizza size: "+pizzaSize+"add to pizza price: "+addToPizzaPrice;
        }
    }

    enum SideDish{
        CALZONE("Calzone", 15), 
        CHICKEN_PUFF("Chicken Puff", 20),
        MUFFIN("Muffin", 12),
        NOTHING("No side dish", 0);

        private final String sideDishName;
        private final int addToPizzaPrice;

        SideDish(String sideDishName,int addToPizzaPrice){
            this.sideDishName=sideDishName;
            this.addToPizzaPrice=addToPizzaPrice;
        }

        public String getSideDishName(){
            return sideDishName;
        }
        public int getAddToPizzaPrice(){
            return addToPizzaPrice;
        }

        @Override
        public String toString(){
            return "side dish name: "+sideDishName+"add to pizza price: "+addToPizzaPrice;
        }
        }

        enum Drinks{
            COCA_COLA("Coca Cola", 8), 
            COCOA_DRINK("Cocoa Drink", 10),
            NOTHING("No drinks", 0);

            private final String drinkName;
            private final int addToPizzaPrice;

            Drinks(String drinkName,int addToPizzaPrice){
                this.drinkName=drinkName;
                this.addToPizzaPrice=addToPizzaPrice;
            }

            public String getDrinkName(){
                return drinkName;
            }
            public int getAddToPizzaPrice(){
                return addToPizzaPrice;
            }

            @Override
            public String toString(){
                return "drink name: "+drinkName+"add to pizza price: "+addToPizzaPrice;
            }
        }

        public final double PIZZA_BASE_PRICE = 10.0;
        static String[] pizzasOrdered = new String[10];
        static String[] pizzaSizesOrdered = new String[10];
        static String[] sideDishesOrdered = new String[20];
        static String[] drinksOrdered = new String[20];



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
        while (true){ 
                System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here's what we serve: ");
                PizzaSelection pizzaSelection[]=PizzaSelection.values();
                for(int i=0;i<PizzaSelection.values().length;i++){
                    System.out.println((i+1)+". "+pizzaSelection[i]);
                }
                System.out.println((PizzaSelection.values().length+1)+". Custom Pizza with a maximum of 10 toppings that you choose.");
                System.out.println("Please enter your choose(1-6): ");
                do{
                ingChoice1=input.nextInt();
                if(ingChoice1<1||ingChoice1>6){
                    System.out.println("Invalid choices. Please pick from the list: \n");
                } 
                }while(ingChoice1<1||ingChoice1>6);
        
                if(ingChoice1>=1&&ingChoice1<=PizzaSelection.values().length){
                    PizzaSelection selectedPizza=PizzaSelection.values()[ingChoice1-1];
                    pizzasOrdered[orderIndex]=selectedPizza.getPizzaName()+": €"+selectedPizza.getPrice();
                    totalorderPrice+=selectedPizza.getPrice();
                }
                else if(ingChoice1==PizzaSelection.values().length+1){
                    System.out.println("Availble toppings: ");
                    PizzaToppings pizzatoppings[]=PizzaToppings.values();
                    for(int j=0;j<PizzaToppings.values().length;j++){
                        System.out.println((j+1)+"."+pizzatoppings[j]);
                    }
                    StringBuilder customerToppingChoice=new StringBuilder("Custom Pizza with ");        
                    double customPizzaPrice=PIZZA_BASE_PRICE;
                    input.nextLine();
                    String customToppings[];
                    do{
                    System.out.println("Please enter no more than 10 choices(separated by commas): ");
                    customToppings=input.nextLine().split(",");
                    if(customToppings.length>10){
                        System.out.println("You entered more than 10 choices. Please try again: ");
                    } 
                    }while(customToppings.length>10);
                        for(int i=0;i<customToppings.length;i++){
                        int toppings=Integer.parseInt(customToppings[i]);
                        for(int j=0;j<pizzatoppings.length;j++){
                            if(toppings==(j+1)){
                                customerToppingChoice.append(pizzatoppings[j].getTopping());
                                customPizzaPrice+=pizzatoppings[j].getToppingPrice();
                            }
                        }
                    }
                    customerToppingChoice.append(",");
                    pizzasOrdered[orderIndex]=customerToppingChoice.toString()+": €"+customPizzaPrice;
                    totalorderPrice+=customPizzaPrice;
                }

                System.out.println("Availble pizza sizes: ");
                PizzaSize pizzaSize[]=PizzaSize.values();
                for(int i=0;i<PizzaSize.values().length;i++){
                    System.out.println((i+1)+". "+pizzaSize[i]);
                }
                System.out.println("Please enter the pizza size: ");
                do{
                ingChoice2=input.nextInt();
                if(ingChoice2<1||ingChoice2>PizzaSize.values().length){
                    System.out.println("Invalid choices. Please pick from the list: " );
                }
                }while(ingChoice2<1||ingChoice2>PizzaSize.values().length);
                if(ingChoice2>=1&&ingChoice2<=PizzaSize.values().length){
                    PizzaSize selectedSize=PizzaSize.values()[ingChoice2-1];
                    pizzaSizesOrdered[orderIndex]=selectedSize.getPizzaSize()+": €"+selectedSize.getAddToPizzaPrice();
                    totalorderPrice+=selectedSize.getAddToPizzaPrice();
                }

                System.out.println("Available side dishes: ");
                SideDish sidedish[]=SideDish.values();
                for(int i=0;i<SideDish.values().length;i++){
                    System.out.println((i+1)+". "+sidedish[i]);
                }
                System.out.println("Please enter the side dishes: ");
                do{
                ingChoice3=input.nextInt();
                if(ingChoice3<1||ingChoice3>SideDish.values().length){
                    System.out.println("Invalid choices. Please pick from the list: ");
                }
                }while(ingChoice3<1||ingChoice3>SideDish.values().length);
                if(ingChoice3>=1&&ingChoice3<=SideDish.values().length){
                    SideDish selectedSideDish=SideDish.values()[ingChoice3-1];
                    sideDishesOrdered[orderIndex]=selectedSideDish.getSideDishName()+": €"+selectedSideDish.getAddToPizzaPrice();
                    totalorderPrice+=selectedSideDish.getAddToPizzaPrice();
                }

                System.out.println("Available drinks: ");
                Drinks drinks[]=Drinks.values();
                for(int i=0;i<Drinks.values().length;i++){
                    System.out.println((i+1)+". "+drinks[i]);
                }
                System.out.println("Please enter the drinks: ");
                do{
                    ingChoice4=input.nextInt();
                    if(ingChoice4<1||ingChoice4>Drinks.values().length){
                        System.out.println("Invalid choices. Please pick from the list: ");
                    }
                }while(ingChoice4<1||ingChoice4>Drinks.values().length);
                if(ingChoice4>=1&&ingChoice4<=Drinks.values().length){
                    Drinks selectedDrinks=Drinks.values()[ingChoice4-1];
                    drinksOrdered[orderIndex]=selectedDrinks.getDrinkName()+": €"+selectedDrinks.getAddToPizzaPrice();
                    totalorderPrice+=selectedDrinks.getAddToPizzaPrice();
                }

                orderIndex++;
                input.nextLine();

                System.out.println("Do you want to place another order? (Y/N): ");
                String anotherOrder=input.nextLine();
                if(anotherOrder.equals("N")){
                    break;
                    } 
                }



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
