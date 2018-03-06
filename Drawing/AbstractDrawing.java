
/**
 * Abstract class AbstractDrawing - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
import java.util.ArrayList;
public abstract class AbstractDrawing
{
    String colour;
    
    // ArrayList to hold both Drawings and Shapes
    protected ArrayList<AbstractDrawing> drawings = new ArrayList();
    public void setColour(String colour) throws IllegalArgumentException
    {       
        colour = colour.toLowerCase();// change to lower case
        
        // check if colour is valid
        if(colour.equals("green") || colour.equals("white") || colour.equals("gold"))
        {
            this.colour = colour;
        }
        else
        {
            throw new IllegalArgumentException(colour +" is not a valid colour");
        }  
        // loop through ArrayList to set colour
        for(AbstractDrawing draw: drawings)
        {
            if(draw instanceof Shape) // check if drawing is a shape object
            {
                draw.setColour(colour); // recall method to step into Drawing Class in ArrayList                           
            }
        }
    }
     public String getColour()
    {
        return this.colour;        
    }
    public void add(AbstractDrawing drawing) // add drawings to ArrayList
    {
          this.drawings.add(drawing);
    }
    public abstract void print();
}
