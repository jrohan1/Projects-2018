
/**
 * Write a description of class Wheel here.
 *
 * @author (Joan Rohan)
 * @version (a version number or a date)
 */
public class Wheel
{
    // instance variables - replace the example below with your own
    private int radius;
    private double circumference;
    private String name;
       /**
     * Constructor for objects of class Wheel
     */
    public Wheel(String name,int radius)
    {
        // initialise instance variables
        this.radius = radius;
        this.name = name;
        this.circumference =  2 * Math.PI * radius;
    }
        public void getName()
    {
        this.name = name;
    }
    public double getRadius()
    {
        return radius;
    }
    public void setRadius(int radius)
    {
        this.radius = radius;
    }
       public double getCircumference()
    {
        // put your code here
        return circumference;
    }   
}
