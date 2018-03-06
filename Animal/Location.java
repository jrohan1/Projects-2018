
/**
 * Write a description of class Location here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Location
{
    // instance variables - replace the example below with your own
    public final int x;
    public final int y;
    private GridObject gridObject;
    private boolean occupied;
    /**
     * Constructor for objects of class Location
     */
    public Location(int x, int y)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object object)
    {
        if(object == null)
        {
            return false;
        }
        if (object instanceof Location)
        {
            Location location = (Location) object;
            if(location.x == x && location.y == y)
            {
                return true;
            }
        }
        return false;
    }
    public void setGridObject(GridObject gridObject)// if position in arraylist is empty occupied = false
    {
        if(gridObject == null){
            this.gridObject = null;
            occupied = false;
            return;
        }
        this.gridObject = gridObject;
        occupied = true;
    }
    public GridObject getGridObject()
    {
        return this.gridObject;
    }
    public boolean getOccupied()
    {
        return occupied;
    }
}
