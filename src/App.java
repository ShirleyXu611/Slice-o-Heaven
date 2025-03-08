public class App {
    public static void main(String[] args)throws Exception{
    Slice_o_Heaven pizza = new Slice_o_Heaven();
    pizza.specialOfTheDay("Cheese pizza", "Chips", "$9.99");
    pizza.takeOrder();
    System.out.println(pizza);
    }
}