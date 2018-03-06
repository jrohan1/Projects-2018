
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat extends Feline implements GridObject
{
    // instance variables - replace the example below with your own
  
    private Location location;
    /**
     * Constructor for objects of class Cat
     */
    public Cat(String name)
    {
        // initialise instance variables
        super();
        this.name = name;
        colour = "black";
        energy = 10;
    }
    @Override
    public String toString(){
        String strng ="";
        strng+= name;
        strng+= " the Cat ";
        return strng;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    @Override
    public boolean eat(Food food)
    {
       
        if(food ==null){ // if the reference points to null
            return false; // immediately return.  Method execution goes no further
        }
        
        if(food instanceof Canary){ // is food pointing to a Canary object?
            Canary canary = (Canary) food; // cast reference to a Canary type
            energy += canary.extractEnergy(); // extract the Canarys energy
            return true; // return. Method execution goes no further
        }else{
          System.out.println("I cannot eat this type of food");
          energy -= 5; // cat looses alot of energy if he cannot eat
        }
        return false;
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
    @Override // move method to set location in arraylist
    public boolean move(Location location)
    {
        if(getEnergy() <= 0) // if energy is 0 cat cannot move
        {
            System.out.println(getName() + " is out of energy and cannot move");
            return false;
        }
        else
        {
            setLocation(location);
            location.setGridObject(this);
            energy -=2;
        } 
        return true;               
    }
}
