import java.awt.Image;

public class Spaceship extends Sprite2D {

	public Spaceship(Image i, Image i2) {
		super(i,i2);
		
	}
	
	public void setXSpeed(double dx) {
		xSpeed = dx;
	}
	
	public void move() {
		this.x += xSpeed;
		
		if(x<0) {
			x = 0;
			xSpeed = 0;
		}
		else if (x>winWidth-myImage.getWidth(null)) {
			x = winWidth-myImage.getWidth(null);
			xSpeed = 0;
		}
	}

}
