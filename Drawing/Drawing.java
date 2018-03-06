
/**
 * Write a description of class Drawing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class Drawing extends AbstractDrawing
{
    public Drawing()
    {
        super();
    }
    @Override
    public void print()
    {         
        for(AbstractDrawing draw: drawings) // for each item in ArrayList call print()
        {
            draw.print();
        }
    }
}
