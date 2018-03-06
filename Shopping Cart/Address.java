
/**
 * Write a description of class Address here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Address
{
    // instance variables - replace the example below with your own
    private String street;
    private String city;
    private String zip;
    private String country;
   
    /**
     * Constructor for objects of class Address
     */
    public Address(String street,String city, String zip, String country)
    {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    //setters and getters
    public String getStreet()
    {
        return street;
    }
    public String getCity()
    {
        return city;
    }
    public String getZip()
    {
        return zip;
    }
    public String getCountry()
    {
        return country;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setZip(String zip)
    {
        this.zip = zip;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }
    // concatonate variables into a string
    public String getBillingAddress()
    {        
        String billing = "Street: " + street + "\n\tCity: " + city +"\n\tZIP: " + zip+ "\n\tCountry:" +country;
        
        return billing;
    }
    public String getDeliveryAddress()
    {        
        String delivery = "Street: " + street + "\n\tCity: " + city +"\n\tZIP: " + zip+ "\n\tCountry:" +country;
        
        return delivery;
    }
}
