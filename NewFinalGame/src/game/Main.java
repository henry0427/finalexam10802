package game;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main{

	public static void main(String[] args) {
		// Run UI in the Event Dispatcher Thread (EDT), instead of Main thread
//	      javax.swing.SwingUtilities.invokeLater(new Runnable() {
//	         public void run() {
	            JFrame frame = new JFrame("Final Game");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setContentPane(new GamePanel(640, 480)); // BallWorld is a JPanel
	            
	            frame.pack();            // Preferred size of BallWorld
	            frame.setVisible(true);  // Show it
//	         }
//	      });
	}

}
