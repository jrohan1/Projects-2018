
/**
 * Write a description of class ShoppingCart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class ShoppingCart
{
    // instance variables - replace the example below with your own
    private final long cartId;
    private String timeStamp;
    private ArrayList<Item> items;
    private float total = 0;
    private Customer customer;
    private Order order;
    private Item item;
    private boolean lock;
    /**
     * Constructor for objects of class ShoppingCart
     */
    // ShoppingCart initalised by Customer
    public ShoppingCart(Customer customer)
    {
        this.customer = customer;
        this.items = new ArrayList<>();
        cartId = (long)Math.random() * 99999999999999L;
        timeStamp = timeStamp;
        boolean lock = false; // lock set to false until called
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // add item to cart as long as the cart is not locked
    public void addItem(Item item)
    {
        if (lock == false)
        {
        items.add(item);
        }
        else
        {
        System.out.println("Sorry the shopping cart is closed");
        }
    }
    public ArrayList<Item> getItems()
    {
        return items;
    }
    // remove item from cart as long as the cart is not locked
       public void removeItem(Item item)
    {
        if (lock == false)
        {
        items.remove(item); 
        }
        else
        {
        System.out.println("Sorry the shopping cart is closed");
        }
    }
    // for every item in Item add prices return total
    public float getTotal()
    {
        for(Item item:items)
        {
            this.total+=item.getPrice();
        }
        return total;
        }
    // print out items from the toString method in Item
    public void printItems()
    { 
        for(Item item: items)
        {
            System.out.println(item.toString());
        }
            System.out.println("\t\t\t\t-----");
            System.out.println("\t\t\tTotal:"+getTotal());         
        }   
    public long getCartId()
    {
        return this.cartId;
    }
    public Customer getCustomer()
    {
          return this.customer;
    }
    // lock method set to true when called, create new order
    public void lock()
    {
        lock = true;
       this.order = new Order(this);
    }
}
