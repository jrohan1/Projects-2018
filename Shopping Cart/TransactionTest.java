
/**
 * TransactionTest is a class that does one thing only
 * It provides methods for testing out different test scenarios 
 * for our Shopping Cart Transaction classes
 * @author Conor Hayes
 * @version 28 September 2017
 */
public class TransactionTest
{
    
    /**
     * main method to execute the TransactionTest methods
     */
    public static void main(String[] args)
    {
       TransactionTest test = new TransactionTest();
       test.transaction1(); 
       test.transaction2(); 
       // calls the method with our test scenario
    }
    
    public void transaction1()
    {        
    //1. Create New Customer
    Customer customer = new Customer("Niamh", "O'Leary", "niamhol@zmail.com");
    
    //2. Create a Shopping Cart for the Customer
    ShoppingCart cart = new ShoppingCart(customer);
    // create three items
    Item item1 = new Item("Oven",12345);
    Item item2 = new Item("Fridge",34567);
    Item item3 = new Item("TV",67859);
    // set prices
    item1.setPrice(1000);
    item2.setPrice(500);
    item3.setPrice(700);
    // add items to cart
    cart.addItem(item1);
    cart.addItem(item2);
    cart.addItem(item3);
    cart.getCustomer();
    cart.getItems();
    cart.getCartId();
    //create order
    Order order = new Order(cart);
    order.order();
    order.getOrderNumber();
    // create address
    Address address = new Address("16 Newcastle","Galway","GW123","Ireland");
    Payment pay = new Payment(customer, address, "MasterCard", 12333, 10.99,"12/11/2017");
    pay.getCardType();
    pay.cardType("Mastercard");
    pay.isValid();
    Email email = new Email(customer, order,cart, address);
    email.sendEmail(pay);
    }
    public void transaction2()
    {  
        
    //1. Create New Customer
    Customer customer = new Customer("Niamh", "O'Leary", "niamhol@zmail.com");
    
    //2. Creat a Shopping Cart for the Customer
    ShoppingCart cart = new ShoppingCart(customer);
    Order order = new Order(cart);
    // create three items
    Item item1 = new Item("Oven",12345);
    Item item2 = new Item("Fridge",34567);
    Item item3 = new Item("TV",67859);
    item1.setPrice(1000);
    item2.setPrice(500);
    item3.setPrice(700);    
    cart.addItem(item1);
    cart.addItem(item2);
    cart.addItem(item3);
    cart.printItems();
    order.remove(item1);
    cart.lock();
    cart.printItems();
    Address address = new Address("16 Newcastle","Galway","GW123","Ireland");
    Payment pay = new Payment(customer, address, "NasterCard", 12333, 10.99,"12/11/2017");
    pay.getCardType();
    // input invalid card type
    pay.cardType("Nastercard");
    pay.isValid();
    // email customer
    Email email = new Email(customer, order,cart, address);
    email.sendEmail(pay);
    }
}
