package Assignment1;
import java.awt.*;
import javax.swing.*;

public class MyApplication extends JFrame {

	private static final Dimension WindowSize = new Dimension(600,600);
	
	public MyApplication() {
		//Create and set up the window.
		this.setTitle("Pacman, or something..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Display the window, centred on the screen
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		setVisible(true);
		
	}
	
	public static void main(String [ ] args) {
		MyApplication w = new MyApplication();
		}
	
	public void paint (Graphics g) {
				
		int x = 25;
		int y = 40;
		for(int i=0; i<15; i++) {
			y = y + 35;	
			x=25;
			for(int j = 0; j < 15; j++) {
					int a =  (int)(Math.random()*255);
					int b =  (int)(Math.random()*255);
					int c =  (int)(Math.random()*255);
					Color col = new Color(a,b,c);
					g.setColor(col);			
					int size = 30;
					g.fillRect(x, y, size, size);
					x = x + 35;
			}			
			
		}
		
		
		
		}
	
}
