
/**
 * Write a description of class Shape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shape extends Drawing
{
    public Shape()
    {
        // initialise instance variables
        super();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
   
    @Override // print statement for all of shapes subclasses
    public void print()
    {
        System.out.println("Drawing "+ getClass().getSimpleName()+" with colour " + getColour());
    }
}
