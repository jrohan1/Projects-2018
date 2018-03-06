
/**
 * the CarDemo class only exist to test different Car/Engine/Wheel configurations
 *
 * @author Conor Hayes
 * @version September 25th 2017
 */
public class CarDemo
{
    // instance variables - replace the example below with your own
    private double fuel;
    private Car car; // reference variable for any Car object used in this class
    private Engine engine; // reference variable for any Engine object used in this class
    private Wheel wheel; // reference variable for any Wheel object used in this class

    /**
     * Constructor for objects of class CarDemo
     */
    public CarDemo()
    {
    // Constructor does nothing in this class  
    // in fact if you delete it, the class will still compile
     
    }
    
    public void setCar(Car car){
        this.car = car;
    }
    
    
    public void setFuel(double fuel){
        this.fuel = fuel;
    }

    
    public static void main(String[] args)
    {
        double fuel = 100;
        CarDemo demo = new CarDemo(); //create a new Car Demo object
        demo.setFuel(fuel); // set the fuel value in the Car Demo object. This value will be used in each test
        
        Car car = new Car("X7"); // new Car X7
        demo.setCar(car); // Car X7 will be the 'base' car for the next 3 test runs (each with a different Engine/Wheel
        demo.testConfig1(); // call the testConfig1 method ( Engine DR9 and Wheel 'Wichelin15')
        demo.testConfig2(); // call the testConfig2 method ( Engine F-alpha and Wheel 'GetAGrip11.5')
        demo.testConfig3(); // call the testConfig3 method (Engine DRX Turbo and Wheel 'MoodYear12.5')
        
        car = new Car("Django"); // new Car 'Django'
        demo.setCar(car);  // Car Django will be the 'base' car for the next 3 test runs (each with a different Engine/Wheel
        demo.testConfig1(); // call the testConfig1 method ( Engine DR9 and Wheel 'Wichelin15')
        demo.testConfig2(); // call the testConfig2 method ( Engine F-alpha and Wheel 'GetAGrip11.5')
        demo.testConfig3(); // call the testConfig3 method (Engine DRX Turbo and Wheel 'MoodYear12.5')
        
        
    }
    
    public void testConfig1(){
       
       engine = new Engine("DR9", 10); // new Engine DR9
       car.add(engine); // add the Engine
       wheel = new Wheel ("Wichelin15", 15); // new Wheel Wichelin15
       car.add(wheel); // add the Wheel
       car.setFuel(fuel); // set the Fuel level
       car.run(); // run the car with this configuration
       System.out.println("*********Test Configuration 1 ********");
       System.out.printf("Initial fuel level: %f \n" , fuel );
       car.printState(); // print out the state of the car after this test run
       
    }
    
    
    public void testConfig2(){
       
       engine = new Engine("F-alpha", 22.4); // new Engine
       car.add(engine); // add the engine
       wheel = new Wheel ("GetAGrip11.5", 11);// new Wheel GetAGrip11.5
       car.add(wheel); // add the wheel
       car.setFuel(fuel); // set the Fuel level
       car.run(); // run the car with this configuration
       System.out.println("*********Test Configuration 2 ********");
       System.out.printf("Initial fuel level: %f \n" , fuel );
       car.printState();// print out the state of the car after this test run
    }
    
    public void testConfig3(){
       
       engine = new Engine("DRX Turbo", 12.4); // new Engine F-alpha
       car.add(engine); // add the engine
       wheel = new Wheel ("MoodYear12.5", 12); // new Wheel MoodYear12.5
       car.add(wheel); // add the wheel
       car.setFuel(fuel); // set the Fuel level
       car.run(); // run the car with this configuration
       System.out.println("*********Test Configuration 3 ********");
       System.out.printf("Initial fuel level: %f \n" , fuel );
       car.printState(); // print out the state of the car after this test run
    }
}
