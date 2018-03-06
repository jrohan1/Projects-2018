
/**
 * Write a description of class Canary here.
 *
 * @author (Conor Hayes)
 * @version (October 5th 2017)
 */
public class Canary extends Bird implements Food, GridObject
{
    // instance variables - replace the example below with your own
    private Location location;
    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        energy = 10; // energy initalised and set to 10.
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing(){
        System.out.println("tweet tweet tweet");
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
    @Override
    public String toString(){
        String strng ="";
        strng+= name;
        strng+= " the Canary ";
        
        //strng+= "; ";
        //strng+= "colour: ";
        //strng+= colour;
        //strng+= "\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return strng;
    }
     /**
     * eat method :  if the Canary can eat this type of Food
     * then it extracts the Food's energy and sings
     * @param Food food - a reference to an object of type Food
     */
    
    @Override
    public boolean eat(Food food){
        if(food ==null){ // if the reference points to null
            return false; // immediately return.  Method execution goes no further
        }
        
        if(food instanceof Seed){ // is food pointing to a Seed object?
            Seed seed = (Seed) food; // cast reference to a Seed type
            energy += seed.extractEnergy(); // extract the Seeds energy
            sing(); // sing 
            return true; // return. Method execution goes no further
        }else{
          energy --; // if canary cannot eat it looses energy
          System.out.println("I cannot eat this type of food");
        }
        return false;
    }
    @Override
    public int extractEnergy(){
       int cal = energy; // temp variable cal holds value of energy
       energy = 0; // now set energy to be zero
       return cal; // return value assigned to cal
    }
    @Override
    public int getCalories(){
        return energy;
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
        if(getEnergy() <= 0) // if energy is 0 bird cannot move
        {
            System.out.println(getName() + " is out of energy and cannot move");
            return false;
        }
        else
        {
            setLocation(location);
            location.setGridObject(this);
            energy --;
        } 
        return true;               
    }
}