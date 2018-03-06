import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Iterator;


public class InvadersApplication extends JFrame implements Runnable, KeyListener {
	
	// member data
	private static final Dimension WindowSize = new Dimension(800,600);
	private static final int NUMALIENS = 30;
	private Alien[] AlienArray = new Alien[NUMALIENS];
	private Spaceship PlayerShip;
	private Image alienImage, alien2, playerImage, bulletImage;
	private ArrayList bulletsList = new ArrayList();
	private static String workingDirectory;
	private boolean isInitialised = false;
	private BufferStrategy strategy;
	private Graphics offscreenGraphics;
	private int w1, w2, h1, h2;
	private int score, bestScore, speed;
	private int remainingAliens = NUMALIENS;
	private boolean inPlay = false;
		
	// constructor
	public InvadersApplication() {
		
		//Create and set up the window.
		this.setTitle("Space Invaders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inPlay = false;
				
		//Display the window, centred on the screen
		Dimension screensize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x = screensize.width/2 - WindowSize.width/2;
		int y = screensize.height/2 - WindowSize.height/2;
		setBounds(x, y, WindowSize.width, WindowSize.height);
		setVisible(true);
		
		ImageIcon icon = new ImageIcon(workingDirectory + "\\alien_ship_1.png");
		alienImage = icon.getImage();
		ImageIcon icon2 = new ImageIcon(workingDirectory + "\\alien_ship_2.png");
		alien2 = icon2.getImage();
		for (int i =0; i< NUMALIENS; i++) {
			AlienArray[i] = new Alien(alienImage, alien2);
		}
		ImageIcon player = new ImageIcon(workingDirectory + "\\player_ship.png");
		playerImage = player.getImage();
		PlayerShip = new Spaceship(playerImage,playerImage);
		
		ImageIcon bullet = new ImageIcon(workingDirectory + "\\bullet.png");
		bulletImage = bullet.getImage();
		
		
		Sprite2D.setWinWidth(WindowSize.width);		

		Thread t = new Thread(this);
		t.start();	
		
		// Buffer
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		offscreenGraphics = strategy.getDrawGraphics();
				
		addKeyListener(this);
		isInitialised = true;
	}
	
	private void startGame() {		
			if (!inPlay) {
				inPlay = true;
				score = 0;
				speed = 0;
				startNewWave();
			}
			
	}
	
	private void startNewWave() {
		if (inPlay = true) {
		speed = speed +4;
		remainingAliens = NUMALIENS;
							
		for (int i =0; i< NUMALIENS; i++) {
			AlienArray[i] = new Alien(alienImage, alien2);
			double xx= (i/5)*80 +70;
			double yy = (i % 5)*40 + 75;
			AlienArray[i].setPosition(xx,yy);
			AlienArray[i].alive = true; 
			AlienArray[i].setFleetXSpeed(speed + 1);
			}		
		}
		PlayerShip.setPosition(300,500);
	}
	
	// thread entry point
	public void run() {
	
		while (true) {
			try { 				
				Thread.sleep(50);			
			}catch (InterruptedException e) {
				
			}
			boolean reverse= false;
			for (int i =0; i< NUMALIENS; i++) {
				if(AlienArray[i].alive) {
				if(AlienArray[i].move())
					reverse= true;
				}
			}
				if(reverse) {
					for (int i =0; i< NUMALIENS; i++) {
						if(AlienArray[i].alive) {					
							AlienArray[i].reverseDirection();
							}
						if(AlienArray[i].y > WindowSize.height - 120) {
							inPlay = false;
						}
				}			
			}			
			PlayerShip.move();
			
			Iterator iterator = bulletsList.iterator();
			while(iterator.hasNext()) {
			PlayerBullet b = (PlayerBullet) iterator.next();
			if (b.move()) {
				iterator.remove();
			} 
			else {
			double x2 = b.x;
			double y2 = b.y;
			
			w1 = alienImage.getWidth(null);
			h1 = alienImage.getHeight(null);

			w2 = bulletImage.getWidth(null);
			h2 = bulletImage.getHeight(null);
			
			for (int i = 0; i < NUMALIENS; i++) {
				if(AlienArray[i].alive) {
				double x1 = AlienArray[i].x;
				double y1 = AlienArray[i].y;	
				if (((x1 <= x2 && x1 + w1 >= x2) || (x2 <= x1 && x2 + w2 >= x1)) 
						&& ((y1 <= y2 && y1 + h1 > y2) || (y2 <= y1 && y2 + h2 >= y1)))
				{
					AlienArray[i].alive = false;
					b.alive = false;
					score = score + 5;
					remainingAliens --;
					if (remainingAliens == 0) {
						startNewWave();
					}
					if (score > bestScore) {
						bestScore = score;
					}				
					iterator.remove();
					break;
					}
				}				
			}				
		}
	}
			this.repaint();
		}
	}
	
	
	//Three Keyboard Event Handling functions
	public void keyPressed(KeyEvent e) {
		 int key = e.getKeyCode();
		 
		 if(inPlay) {
	        if (key == KeyEvent.VK_LEFT) {
	        
	            PlayerShip.setXSpeed(-5);
	        }

	        if (key == KeyEvent.VK_RIGHT) {
	        
	        	PlayerShip.setXSpeed(5);
	        }
	        if (key == KeyEvent.VK_SPACE) {
	        	this.shootBullet();
	        }	       
		 }
	     else {
	    	 	if (key == KeyEvent.VK_ENTER) {
		        	startGame();
		        } 	       
	     
	     } 
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT ) {
        
        	PlayerShip.setXSpeed(0);
        }

    }
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void shootBullet() {
		PlayerBullet b = new PlayerBullet(bulletImage,bulletImage);
		b.setPosition(PlayerShip.x+54/2, PlayerShip.y);
		bulletsList.add(b);
	}
	
	// application's paint method
	public void paint(Graphics g) {
		if(!isInitialised)
			return;
		g = strategy.getDrawGraphics();
	
		if(!inPlay) {
			int fontSize = 50;	
			int fontSize1 = 35;
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 800, 600);
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
			g.drawString("Game Over ",300,150);
			g.drawString("Press Enter to Start Game",200,200);
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize1));
			g.drawString("Arrow keys to move, Space to fire",200,250);
		} else {

		int fontSize = 35;		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
		g.drawString("Score: " +score+ " Best Score: " +bestScore,300,70);	

				
		for (Alien sprite : AlienArray ) {
			if(sprite.alive)
				sprite.paint(g);
		}
		PlayerShip.paint(g);
		
		Iterator iterator = bulletsList.iterator();
		while(iterator.hasNext()) {
		PlayerBullet b = (PlayerBullet) iterator.next();
		if(b.alive)
		b.paint(g);
		}
		}
		g.dispose();
		strategy.show();
	}
	
	// application entry point
	public static void main(String[] args) {
		workingDirectory = System.getProperty("user.dir");
		System.out.println("Working Directory = " + workingDirectory);
		
		InvadersApplication invaders = new InvadersApplication();
	}
}

