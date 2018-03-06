import java.awt.Image;

public class PlayerBullet extends Sprite2D {
	private double ySpeed = 0;
	
	public PlayerBullet(Image i, Image i2) {
		super(i, i2);
		alive = true;
	}
	
	public boolean move() {
		this.y -=10;
		if(y <= 0 || y >= 600-myImage.getHeight(null)) {
			return true;		
		}
		return false;
		
	}
	
	public void setYSpeed(double dy) {
		ySpeed = dy;
	}

}

