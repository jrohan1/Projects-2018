import java.awt.*;
import javax.swing.*;

public class MovingSquaresApplication extends JFrame implements Runnable {
	
	// member data
	private static final Dimension WindowSize = new Dimension(600,600);
	private static final int NUMGAMEOBJECTS = 30;
	private GameObject[] GameObjectsArray = new GameObject[NUMGAMEOBJECTS];
	
	
	// constructor
	public MovingSquaresApplication() {
		//Create and set up the window.
				this.setTitle("Threads and Animation");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Display the window, centred on the screen
				Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
				int x = screensize.width/2 - WindowSize.width/2;
				int y = screensize.height/2 - WindowSize.height/2;
				setBounds(x, y, WindowSize.width, WindowSize.height);
				setVisible(true);
				
				for (int i = 0; i < NUMGAMEOBJECTS; i++) {
					GameObjectsArray[i] = new GameObject();
					
				}
				
				Thread t = new Thread(this);
				t.start();				
					
	}
	
	// thread's entry point	
	public void run(){
		
		while (true) {
			try { 
				for (GameObject gameObj : GameObjectsArray ) {
					
					gameObj.move();
				}
				Thread.sleep(20);
			
			}catch (InterruptedException e) {
				 e.printStackTrace();
			}
			
			this.repaint();
		}
	}
	
	// application's paint method
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 600);
		
		for (GameObject gameObj : GameObjectsArray ) {
			gameObj.paint(g);
			
		}
	}
	
	// application's entry point
	public static void main(String[] args) {
		MovingSquaresApplication a = new MovingSquaresApplication();
		}
}
