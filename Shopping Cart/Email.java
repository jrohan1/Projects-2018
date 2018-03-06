
/**
 * Write a description of class Email here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Email
{
    // instance variables - replace the example below with your own
    private Customer customer;
    private Payment payment;
    private Order order;
    private ShoppingCart shoppingCart;
    private Address address;
    private Item item;
    String emailAddress;

    /**
     * Constructor for objects of class Email
     */
    public Email(Customer customer, Order order,ShoppingCart shoppingCart, Address address)
    {
      this.emailAddress = customer.getEmailAddress();
      this.customer = customer;
      this.order = order;
      this.address = address;
      this.shoppingCart = shoppingCart;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // if Payment is valid printState1 is called otherwise printState2 is called
    public void sendEmail(Payment payment)
    {
        boolean valid = payment.isValid();
        
        if (valid)
        {
            printState1();
        }
        else
        {
            printState2();
        }
    }
    // email to confirm a valid order
     public void printState1()
    {
        System.out.printf("Hi %s \t\t%s\n\n", customer.getFirstName(),emailAddress);
        System.out.println("Your order has been successfully logged");
        System.out.printf("Your Order Number is: %d \n\n",order.getOrderNumber());
        System.out.println("Delivery Address:");
        System.out.printf("\t%s \n",address.getDeliveryAddress());
        System.out.println("Your Order Statement:\n");
        order.printOrder();
    }
    // email to say order is not valid
    public void printState2()
    {
        System.out.printf("Hi %s \t\t%s\n", customer.getFirstName(),emailAddress);
        System.out.println("\nYour order has not been logged \n Invalid details");
    }
}
