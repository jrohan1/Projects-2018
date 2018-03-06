
/**
 * Write a description of class Engine here.
 *
 * @author (Joan Rohan)
 * @version (a version number or a date)
 */
public class Engine
{
    // instance variables - replace the example below with your own
    private double fuel;
    private double efficiency;
    private String name;
           /**
     * Constructor for objects of class Engine
     */
    public Engine(String name, double efficiency)
    {
        // initialise instance variables
        this.name = name;
        this.efficiency = efficiency;
       
    }

    public void setFuel(double fuel){
        this.fuel =fuel;
    }
    
    public double getFuel(){
         return fuel;
    }
    public void getName()
    {
        this.name = name;
    }
    public void setEfficiency(double efficiency)
    {
        this.efficiency = efficiency;
    }
    public double getEfficiency()
    {
        return efficiency;
    }
    /**
     * numTurns method calculates the number of times the wheel turns based on 
     * the amount of fuel available and the, turns per litre, efficiency of the engine*/
    public double numTurns()
    {
        double numTurns = fuel*efficiency;
        return numTurns;
    }
     

}