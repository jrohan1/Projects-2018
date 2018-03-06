
/**
 * Write a description of class Animal here.
 *
 * @author (conor hayes)
 * @version (October 5th 2017)
 */
public abstract class Animal
{
    // instance variables - replace the example below with your own
    boolean hasSkin;
    boolean breathes;
    String colour;
    int energy;
    String name;
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        colour = "grey"; //all the subclasses of Animal inherit this property and value
    }
    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public abstract boolean move(int distance);
    public abstract boolean move(Location location);
    /**
     * eat method
     * param Food food - food the Animal should eat
     * We haven't defined this yet
     * All subclasses inherit this method
     */
    public abstract boolean eat(Food food);
    
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour(){
        return colour;
    }
    
     /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */
    
    public boolean hasSkin(){
        return hasSkin;
    }
    
     /**
     * 'getter' method for energy field
     * All subclasses inherit this method
     */
    
    public int getEnergy(){
        return energy;
    }
    public String getName(){
        String str = name;
        str+=" the ";
        Class cls = getClass();
        String className = cls.getSimpleName();
        str+= className;
        return str;
    }
}
