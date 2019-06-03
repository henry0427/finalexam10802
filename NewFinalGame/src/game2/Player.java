package game2;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private int playerLong = 10;
	private int x,y;
	private Color color = Color.YELLOW;
	
	public Player() {
		
	}
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, playerLong, playerLong);
	}

	@Override
	public String toString() {
		return "Player [playerLong=" + playerLong + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
