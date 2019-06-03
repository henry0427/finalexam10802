package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Random;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class GamePanel extends JPanel implements KeyListener, MouseMotionListener{
	
	private static final int UPDATE_RATE = 60; // Frames per second (fps)
	private int x;
	private int playerX=300;
	private int playerY=300;
	private int playerSpeedX=10;
	private int playerSpeedY=10;
	private int playerLong = 10;
	private int playerhp = 3;
	private Player player;
	private ContainerBox box;
	
	private int canvasWidth;
	private int canvasHeight;
	private DrawCanvas canvas;
	Random rand;
	Thread gameThread;
	Timer time;
	
	String userhome = System.getProperty("user.dir");
//	URL classUrl = this.getClass().getResource("http://cur.cursors-4u.net/cursor.png"); 
	String classUrl2 = (userhome+"/image/dotpict_0.png");
	Image imageCursor = Toolkit.getDefaultToolkit().getImage(classUrl2); 
	 
	 
	
	public GamePanel(int width, int height){
		
		canvasWidth = width;
		canvasHeight = height;
		rand = new Random();
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor( imageCursor, new Point(0, 0), "cursor"));
		
		
		
		// Init the Container Box to fill the screen
		box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);
		
		// Init the custom drawing panel for drawing the game
		canvas = new DrawCanvas();
		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);
		
		
		// Handling window resize.
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component) e.getSource();
				Dimension dim = c.getSize();
				canvasWidth = dim.width;
				canvasHeight = dim.height;
				// Adjust the bounds of the container to fill the window
				box.set(0, 0, canvasWidth, canvasHeight);
			}
		});
		//////////////
		addKeyListener(this);
		addMouseMotionListener(this);
		gamestart();
		if(playerhp==0) {
			gameThread.stop();
		}
	}
	
	public void gamestart() {
		
//		player = new Player(playerX, playerY);
		gameThread = new Thread() {
			
			public void run() {
				
				while (true) {
					// Execute one time-step for the game
					if (true) {
						player = new Player(playerX-playerLong/2, playerY-playerLong/2);
						
						// Refresh the display
						repaint();
						// Delay and give other thread a chance
						try {
							Thread.sleep(1000 / UPDATE_RATE);
						} catch (InterruptedException ex) {
						}
						
					}
				}
			}
		};
		
		gameThread.start(); // Invoke GaemThread.run()
	}
	
	/** The custom drawing panel for the bouncing ball (inner class). */
	class DrawCanvas extends JPanel {
		/** Custom drawing codes */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g); // Paint background
			// Draw the box and the ball
			box.draw(g);
			player.draw(g);
			
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Courier New", Font.PLAIN, 12));
			// g.drawString("Ball " + ball.toString(), 20, 30);
		}

		/** Called back to get the preferred size of the component. */
		@Override
		public Dimension getPreferredSize() {
			
			return (new Dimension(canvasWidth, canvasHeight));
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_1) {
			System.out.printf("1\n");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_1) {
			System.out.printf("1\n");
		}
		
//		if (e.getKeyCode() == KeyEvent.VK_1) {
//			System.out.print("1");
//		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
//			System.out.print("w");
//		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//			System.out.print("3");
//		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
//			System.out.print("4");
//		}


	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>playerLong/2 & e.getX()<canvasWidth-playerLong/2) {
		playerX = e.getX();}
		if(e.getY()>playerLong/2 & e.getY()<canvasHeight-playerLong/2) {
		playerY = e.getY();}
		
	}

}
