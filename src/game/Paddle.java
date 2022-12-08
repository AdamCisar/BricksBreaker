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

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (x == 0) {
				x = 0;
			}else {
			setDirectionLeft();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (x == 300) {
				x = 300;
			}else {
			setDirectionRight();
			}
		}
	}

	private void setDirectionRight() {
		x += 10; 		
	}

	private void setDirectionLeft() {
		x -= 10; 
	}

	public void draw(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(x, 480, 100, 8);
	
	}
	
	
	
}
