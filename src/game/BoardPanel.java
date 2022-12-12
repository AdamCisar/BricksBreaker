package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BoardPanel extends JPanel implements ActionListener{
	
	
	static final int GAME_WIDTH = 400;
	static final int GAME_HEIGHT = 500;
	static final Dimension BOARD_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	Paddle paddle;
	Graphics graphics;
	Image image;
	Timer timer;
	int x = 150;
	int ballX = 150;
	int ballY = 100;
	int dirX = +3;
	int dirY = -3;


	
	BoardPanel(){
		paddle = new Paddle(x);
		this.setPreferredSize(BOARD_SIZE);
		this.addKeyListener(new Key());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		timer = new Timer(1,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		//background
		g.setColor(Color.black);
		g.fillRect(0,0,400,500);
		
		//paddle
		paddle.draw(g);
		
		//ball
		g.setColor(Color.orange);
		g.fillOval(ballX,ballY, 15, 15);
		g.dispose();
//		Toolkit.getDefaultToolkit().sync(); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		ballMove();
		repaint();
		
	}
		
	private void ballMove() {
		if (new Rectangle(ballX,ballY, 15, 15).intersects(new Rectangle(x, 480, 100, 8))){
			dirY = -dirY;
		}
		
		ballX += dirX;
		ballY += dirY;
		
		
		//left
		if (ballX < 0) {
			dirX = -dirX;
		}
		//top
		if (ballY < 0) {
			dirY = -dirY;
		}
		//right
		if (ballX > 385) {
			dirX = -dirX;
		}


		
		
	}


	private class Key implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		x = paddle.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	}
}






