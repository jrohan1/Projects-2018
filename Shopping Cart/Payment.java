
/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Payment
{
    // instance variables - replace the example below with your own
    private Customer customer;
    private ShoppingCart shoppingCart;
    private Order order;
    private Email email;
    private String cardType;
    private int cardNumber;
    private String date;
    private String address;
    private double total;
    /**
     * Constructor for objects of class Payment
     */
    // Payment initalised by Customer, Address, card type, card number,total and date
    public Payment(Customer customer, Address address, String cardType, int cardNumber, double total, String date)
    {
        this.customer = customer;
        this.address = address.getBillingAddress();
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.date = date;
        this.total = total;
        this.email = new Email(customer, order, shoppingCart,address);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    // setter and getter methods
    public String getCardType()
    {
        return cardType;
    }
    public int getCardNumber()
    {
        return cardNumber;
    }
    public String getDate()
    {
        return date;
    }
    public double getTotal()
    {
        this.total = shoppingCart.getTotal();
        return total;        
    }
    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }
    public void setCardNumber(int cardNumber)
    {
        this.cardNumber = cardNumber;
    }
    public void setDate(String date)
    {
        this.date = date;
    }
    public void setTotal(double total)
    {
        this.total = total;
    }
      public void createEmail()
    {
        email.sendEmail(this);
    }  
    // check if card type is valid
    public boolean cardType(String cardType)
    {
        String card1 = "MasterCard";
        String card2 = "Visa";
        this.cardType = getCardType();
        if (cardType.equals(card1) || cardType.equals(card2))
        {
            return true;
        }
        return false;            
    }
    // if cardtype is valid isValid returns confirm
    public boolean isValid()
    {
        boolean confirm = cardType(cardType);
        return confirm;
    }
}
