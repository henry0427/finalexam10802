package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private int playerLong = 10;
	private int x,y;
	private int playerhp;
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
	
	public void health(int playerhp) {
		this.playerhp = playerhp;
		if(playerhp>0) {
			playerhp--;
		}
	}

	@Override
	public String toString() {
		return "Player [playerLong=" + playerLong + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
