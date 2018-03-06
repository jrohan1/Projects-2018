
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    

    public static void main(String[] args)
    {      
        Shape tri1 = new Triangle();
        Shape tri2 = new Triangle();
        Shape cir1 = new Circle();
        
        Drawing drawing1 = new Drawing();
        Drawing drawing2 = new Drawing();
        Drawing drawing3 = new Drawing();
        
        drawing3.add(tri2);
        
        drawing2.add(tri1);
        drawing2.add(drawing3);
        
        drawing1.add(cir1);
        drawing1.add(drawing2);
        
        drawing1.setColour("Green");
        drawing2.setColour("White");
        drawing3.setColour("Gold");
        
        drawing1.print();
        System.out.println("--------------------------------");
        
        // throw an exception if colour is invalid
        
        try{
            drawing1.setColour("Green");//valid colour
        }
        catch(IllegalArgumentException e){
           System.out.println(e.getMessage()); 
        }
        try{
            drawing2.setColour("blue");//invalid colour
        }
        catch(IllegalArgumentException e){
           System.out.println(e.getMessage()); 
        }
        try{
            drawing3.setColour("White");//valid colour
        }
        catch(IllegalArgumentException e){
           System.out.println(e.getMessage()); 
        }
        drawing1.print(); 
    }
}