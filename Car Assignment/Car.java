
/**
 * Write a description of class Car here.
 *
 * @author (Joan Rohan)
 * @version (a version number or a date)
 */
public class Car
{
    // instance variables - replace the example below with your own
    private Engine engine;
    private Wheel wheel;
    private String name;
    private double kmsTravelled;
    private double totalDistance;
          /**
     * Constructor for objects of class Car
     */
    public Car(String name)
    {
       this.name = name;
       this.totalDistance = 0;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setFuel(double fuel){
        engine.setFuel(fuel);
    }
    public void add(Engine engine)
    {
        this.engine = engine;
    }
    public void add(Wheel wheel)
    {
        this.wheel = wheel;
    }
    public double totalKms()
    {
        this.kmsTravelled = engine.numTurns()*wheel.getCircumference();
        return kmsTravelled;
    }   
    public void run()
    {
        double travelled = getDistance();
        if(travelled > 0)
        {
          printState();
        }
        else
        {
            System.out.println("NOT ENOUGH FUEL");
        }
    }
     /**
     * accessor method for the totalDistance field*/
      public double getDistance()
    {
        totalDistance = totalDistance + totalKms();
        return totalDistance;
    }
     
   
    
    public void printState()
    {
        // Simulates output from a car dashboard computer.
        System.out.printf("Car name: %s \nTravelled: %.2f kilometers.\n",name,kmsTravelled);
        System.out.printf("Total distance travelled: %.2f kms.\n",totalDistance);
        System.out.println("------------------------------------\n\n");
    }
}