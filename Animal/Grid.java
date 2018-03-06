
/**
 * Write a description of class Grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Grid
{
    private int size = 5;
    private ArrayList<Location> locations; // arraylist to hold locations
    private ArrayList<GridObject> gridObjects = new ArrayList(); // arraylist to hold gridObjects
    private Location location;
    public Grid(int size)
    {
        //GridObject[][] gridObjects = new GridObject[4][4];// two dimentional array
        locations = new ArrayList(size*size);
        for(int i = 0; i < size ; i++)
        {
            for(int j = 0; j< size; j++)
            {
                locations.add(new Location(i,j)); 
                //Location location = new Location(i,j);
                //locations.add(location);
            }
        }
    }
    public void addAvatar(GridObject gridObject, int x, int y)
    {
        gridObjects.add(gridObject); //add gridObject to gridObjects ArrayList
        int index = size* x+y; // position in arraylist
        Location location = locations.get(index); // location and gridobject are placed in arraylists
        locations.get(index).setGridObject(gridObject);
        gridObject.setLocation(location);
    }
    public static void main(String[] args)
    {
        Grid grid = new Grid(5);
        Seed seed = new Seed("Poppy seed");
        Seed seed2 = new Seed("Hay seed");
        Seed seed3 = new Seed("Wheat seed");
        Seed seed4 = new Seed("Oat seed");
        
        grid.addAvatar(seed, 1,1);
        grid.addAvatar(seed2, 2,2);
        grid.addAvatar(seed3, 2,3);
        grid.addAvatar(seed4, 3,1);
        
        Canary joey = new Canary("Joey");
        Canary yellow = new Canary("Yellow");
        
        grid.addAvatar(joey,0,2);
        grid.addAvatar(yellow,2,1);
        
        Cat felix = new Cat("Felix");
        grid.addAvatar(felix,3,3);
        
        grid.start(4);
    }
    public void start(int rounds)
    {
        for(GridObject gridObject: gridObjects) // loop through arraylist gridObjects
        {
            System.out.println(gridObject +"is at location ("+ gridObject.getLocation().x + "," + gridObject.getLocation().y + ")");
        }
        for(int i = 0; i < rounds; i++)
        {
            System.out.println("*** round " + i + "***");
            for(GridObject gridObject: gridObjects)
            {
                System.out.println(gridObject +"is at location ("+ gridObject.getLocation().x + "," + gridObject.getLocation().y + ")");
                if (gridObject instanceof Animal) // check if gridObject is an animal
                {
                    Animal animal = (Animal) gridObject; // cast as animal
                    Location currentLocation = gridObject.getLocation(); // get animals current position in arraylist
                    Location destination = null; // set destination to null 
                    while (destination == null || destination == gridObject.getLocation()) // check destination is not current location
                    {
                        destination = getRandomLocation(); // get random number for new destination
                    }
                    if(!destination.getOccupied())// check if destination position is not occupied already
                    {
                        gridObject.move(destination); // move gridObject 
                        animal.getEnergy();
                    }
                    else
                    {
                        gridObject = destination.getGridObject(); // if grid is already occupied check if it's contents can be eaten
                        if (gridObject instanceof Food)
                        {
                            Food food = (Food) gridObject; // cast as food
                            animal.getEnergy();                            
                            System.out.println(animal+"has Energy levels: " + animal.getEnergy());
                            animal.move(getDistance()); 
                            System.out.println(animal + "is trying to eat "+food );
                            animal.eat(food); // use eat method to check if food can be eaten
                            System.out.println(animal+"now has Energy levels: " + animal.getEnergy());
                            animal.move(destination); // move to new destination
                            removeObj(animal);
                        }
                    }
                }
            }
        }
    }
    public Location getRandomLocation()
    {
        //create random number for index to move avatar to that position 
        int index = (int)(Math.random()*locations.size());
        return locations.get(index);
    }
    public int getDistance()
    {
        //create random number for distance an animal moves
        int distance = (int)(Math.random()*10);
        return distance;
    }
    public void removeObj(Animal animal)
    {
        //remove object from arraylist if its energy <=0
        if(animal.getEnergy() <=0)
        {
            gridObjects.remove(animal);
            System.out.println(animal + "has been removed. Energy levels: " + animal.getEnergy());
        }
    }
}