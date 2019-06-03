package game2;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) {
		// Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
//	      javax.swing.SwingUtilities.invokeLater(new Runnable() {
//	         public void run() {
//	            JFrame frame = new JFrame("Final Game");
				GamePanel gamePanel = new GamePanel(640, 480);
	            gamePanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	            gamePanel.setContentPane(new GamePanel(640, 480)); // BallWorld is a JPanel
	            
	            gamePanel.pack();            // Preferred size of BallWorld
	            gamePanel.setVisible(true);  // Show it
//	         }
//	      });
	}

}
