
/**
 * Write a description of class Bird here.
 *
 * @author (conor hayes)
 * @version (October 5th 2017)
 */
public abstract class Bird extends Animal
{
    //instance variables (fields)
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;

    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "black"; //overrides the value of colour inherited from Animal
        hasFeathers = true; //all the subclasses of Bird inherit this property and value
        hasWings = true; //all the subclasses of Bird inherit this property and value
        flies = true; //all the subclasses of Bird inherit this property and value
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public boolean move(int distance){
        if(energy<=0){// check if the bird has energy
            System.out.println(getName() + " is out of energy and cannot move");
            return false;
        }
        if(flies){
            System.out.printf("I fly %d metres \n", distance);
        }else{
            System.out.printf("I am a bird but cannot fly. I walk %d metres \n", distance);
        }
        energy--;//loses one unit of energy for every move
        if(energy<0){
          energy = 0; // prevents energy having a negative number  
        }
        System.out.println(getName() + " now has Energy level: " + getEnergy());
        return true;
    }
    
    /**
     * sing method that all birds have
     */
    public void sing(){
        System.out.println("tra la la");
    }
    
    /**
     * 'getter' method for the hasWings field
     */
    public boolean hasWings(){
        return hasWings;
    }
    
    /**
     * 'getter' method for the hasFeathers field
     */
    public boolean hasFeathers(){
        return hasFeathers;
    }
}
