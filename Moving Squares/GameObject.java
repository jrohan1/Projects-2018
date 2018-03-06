import java.awt.*;

public class GameObject {

	// member data
	private double x,y;
	
	private Color col;
	
	private int size = 30;
	
	// constructor
	public GameObject() {
		x = (Math.random()*600);
		y =  (Math.random()*600);
		int a =  (int)(Math.random()*255);
		int b =  (int)(Math.random()*255);
		int c =  (int)(Math.random()*255);
		col = new Color(a,b,c);
	}
	
	//public interface
	public void move() {
		
		
			x += 10*(Math.random()-Math.random());
			y += 10*(Math.random()-Math.random());
						
	}
	
	public void paint(Graphics g) {
		
		g.setColor(col);
		g.fillRect((int)x, (int)y, size, size);
	}
}
