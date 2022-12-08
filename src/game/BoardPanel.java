package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardPanel extends JPanel implements ActionListener, KeyListener{
	
	
	static final int GAME_WIDTH = 400;
	static final int GAME_HEIGHT = 500;
	static final Dimension BOARD_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	Paddle paddle;
	Graphics graphics;
	Image image;
	Timer timer;
	int x;

	
	BoardPanel(){
		this.setPreferredSize(BOARD_SIZE);
		this.addKeyListener((KeyListener) this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		timer = new Timer(1,this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}
		
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(1,1,400,500);
		
		g.setColor(Color.cyan);
		g.fillRect(x, 480, 100, 20);
		g.dispose();
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

	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}






