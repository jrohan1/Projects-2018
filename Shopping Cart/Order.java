
/**
 * Write a description of class Order here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Order
{
    // instance variables - replace the example below with your own
    private final long orderNumber;
    private ShoppingCart shoppingCart;
    private Customer customer;
    private ArrayList<Item> item; // array list to hold items from shopping cart
    
        /**
     * Constructor for objects of class Order
     */
    // order initalised by shopping cart 
    public Order(ShoppingCart shoppingCart)
    {
        this.customer = shoppingCart.getCustomer(); // get customer details from shopping cart
        this.item = new ArrayList<>();
        this.orderNumber = (long)(Math.random() * 99999999999999L);
        this.shoppingCart = shoppingCart;
       
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    //get array from shopping cart  
    public ArrayList<Item>order()
    {  
       item = shoppingCart.getItems();
       return item;    
    }
    // for every item in Item print out items
    public void printOrder()
    { 
        for(Item item: item)
        {
            System.out.println(item.toString());
        }
            System.out.println("\t\t\t\t-----");
            System.out.println("\t\t\tTotal:"+shoppingCart.getTotal());
        }
    // for every item in shopping cart remove item - empty cart
    public void remove(Item item)
    {
        for(int i = 0; i< shoppingCart.getItems().size(); i++)
        {
            shoppingCart.removeItem(item);
        }
    }
      public Customer getCustomer(Customer customer)
    {
          this.customer = customer;
          return customer;
    }
    public long getOrderNumber()
    {
        return orderNumber;
    }
}
