package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {

	int x;
	

	public Paddle(int x) {
		this.x = x;
	}

	public int keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (x == 0) {
				x = 0;
			}else {
			return setDirectionLeft();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (x == 300) {
				x = 300;
			}else {
			return setDirectionRight();
			}
		}
		return x;
	}

	private int setDirectionRight() {
		
		return x += 10; 		
	}

	private int setDirectionLeft() {
		
		return x -= 10; 
	}

	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, 480, 100, 8);
	
	}
	
	
	
}
