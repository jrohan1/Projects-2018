import java.awt.*;

import javax.swing.ImageIcon;

public class Sprite2D {

	// member data
	protected double x,y;
	protected double xSpeed = 0;
	protected Image myImage, myImage2;
	int framesDrawn = 0;
	protected static int winWidth;
	protected boolean alive;
		
	// constructor
	public Sprite2D(Image i, Image i2) {
		myImage = i;
		myImage2 = i2;
				
	}

	public void setPosition(double xx, double yy) {
		this.x = xx;
		this.y = yy;
		
	}
	
	public void paint(Graphics g) {
		
		framesDrawn++;
		if ( framesDrawn%100<50 )
		g.drawImage(myImage, (int)x, (int)y, null);
		else
		g.drawImage(myImage2, (int)x, (int)y, null);
		
	}
	
	public static void setWinWidth(int w) {
		winWidth = w;
	}
	public void setX(int x) {
	    
        this.x = x;
    }

    public void setY(int y) {
    
        this.y = y;
    }

    public double getY() {
    
        return y;
    }

    public double getX() {
    
        return x;
    }
    
   	
}
