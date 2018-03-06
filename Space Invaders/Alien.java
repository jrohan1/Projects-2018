import java.awt.Image;
import java.awt.Graphics;

public class Alien extends Sprite2D {
	
	
	public Alien(Image i, Image i2) {
		super(i,i2);
		alive = true;
	}
	
	public void paint(Graphics g) {
		if (alive)
			super.paint(g);
	}
	public boolean move() {
	
		this.x += xSpeed;
		if(x <= 0 || x >= winWidth-myImage.getWidth(null)) {
			return true;		
		}
			return false;
			
	}
	
	public void setFleetXSpeed(double dx) {
		xSpeed = dx;
	}
	public double getFleetXSpeed() {
		return xSpeed;		
	}
	
	public void reverseDirection() {
		
		xSpeed = -xSpeed;
		y += 50;
	}
	
}
	
	


