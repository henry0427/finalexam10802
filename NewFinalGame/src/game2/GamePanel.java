package game2;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class GamePanel extends JFrame implements KeyListener, MouseMotionListener{
	
	private static final int UPDATE_RATE = 100; // Frames per second (fps)
	private int x;
	private int playerX=300;
	private int playerY=300;
	private int playerSpeedX=10;
	private int playerSpeedY=10;
	private int playerLong=10;
	private Player player;
	private ContainerBox box;
	
	private int canvasWidth;
	private int canvasHeight;
	private DrawCanvas canvas;
	Random rand;
	Thread gameThread;
	
	public GamePanel(int width, int height){
		super("Game");
		
		canvasWidth = width;
		canvasHeight = height;
		rand = new Random();
		
		
		
		player = new Player(playerX, playerY);
		
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
//		addMouseMotionListener(this);
		gamestart();
	}
	
	public void gamestart() {
		
		player = new Player(playerX, playerY);
		gameThread = new Thread() {
			
			public void run() {
				
				while (true) {
					// Execute one time-step for the game
					if (true) {
						player = new Player(playerX,playerY);
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
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_1) {
			System.out.printf("1\n");
			System.out.print(canvasWidth+"\n");
			System.out.print(canvasHeight+"\n");
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) { 
			if(playerY>playerLong) {
			playerY -= playerSpeedY;
			System.out.print("Y= "+playerY+"\n");
			}
		} 
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(playerY<canvasHeight-10*playerLong) {
			playerY += playerSpeedY;
			System.out.print("Y= "+playerY+"\n");
			}
		} 
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX<canvasWidth-playerLong) {
			playerX += playerSpeedX;
			System.out.print("X= "+playerX+"\n");
			}
		} 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX>playerLong) {
			playerX -= playerSpeedX;
			System.out.print("X= "+playerX+"\n");
			}
		}
//		player = new Player(playerX, playerY);
//		repaint();


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
		playerX = e.getX();
		playerY = e.getY();
		player = new Player(playerX, playerY);
		repaint();
	}

}
