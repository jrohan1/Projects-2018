
/**
 * Write a description of class Seed here.
 *
 * @author (conor hayes)
 * @version (October 25th 2017)
 */
public class Seed extends Vegetable implements GridObject
{
    // instance variables - replace the example below with your own
    private int calories; 
    String name;
    private Location location;
    /**
     * Constructor for objects of class Seed
     */
    public Seed(String name)
    {
        super();
        this.name = name;
        calories = 10;
    }
    
    
    @Override
    public int getCalories(){
        return calories;
    }
    @Override
    public String toString(){
        String strng ="";
        strng+= name;
        strng+=" has "+calories+" calories";
        strng += " ";
        //strng+= " Seed ";
        return strng;
    }
      /**
     * returns the current value for Calories
     * and then sets the calory value to zero
     * i.e. the energy has been extracted from Seed
     */
    @Override
    public int extractEnergy(){
       int cal = calories; // temp variable cal holds value of calories
       calories = 0; // now set calories to be zero
       return cal; // return value assigned to cal
    }
    public void setLocation(Location location)
    {
        this.location = location;
    }
    @Override 
    public Location getLocation()
    {
        return location;
    }
    @Override // move method set to false because seed does not move
    public boolean move(Location location)
    {
        return false;
    }
}
