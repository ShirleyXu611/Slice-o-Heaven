public class App {
    public static void main(String[] args)throws Exception{
    Slice_o_Heaven pizza = new Slice_o_Heaven();
    pizza.specialOfTheDay("cheese pizza", "chips", "$9.99");
    pizza.takeOrder(); 
    pizza.processCardPayment("12345678912345","02.11.2025", 345);
    }
}
