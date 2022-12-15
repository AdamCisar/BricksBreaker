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
	Bricks bricks;
	int x = 150;
	int ballX = 150;
	int ballY = 400;
	int dirX = 3;
	int dirY = 4;
	int columns = 5;
	int rows = 5;
	boolean play;


	
	BoardPanel(){
		paddle = new Paddle(x);
		bricks = new Bricks();
		this.setPreferredSize(BOARD_SIZE);
		this.addKeyListener(new Key());
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		timer = new Timer(1,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		
		//background
		if(chcekIfWin() == false || chcekIfWin() == true) {
			g.setColor(Color.black);
			g.fillRect(0,0,400,500);
		}
		//win text
		if(chcekIfWin() == true) {
		    g.setColor(Color.lightGray);
			g.drawString("YOU WON THE GAME!!!", 120, GAME_HEIGHT/2);
		}
		//paddle
		if(chcekIfWin() == false) {
			paddle.draw(g);
		}
		//bricks
		if(chcekIfWin() == false) {
			bricks.draw(g);
		}	
		//ball
		if(chcekIfWin() == false) {
			g.setColor(Color.white);
			g.fillOval(ballX,ballY, 15, 15);
			g.dispose();
			
		}
		Toolkit.getDefaultToolkit().sync(); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		checkCollision();
		ballMove();
		repaint();
		chcekIfWin();
	}
		
	private boolean chcekIfWin() {

		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				if (bricks.bricks[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}


	private void checkCollision() {
		Rectangle brick = null;
		int x = 0;
		int y = 30;
		int brickWidth = 50;
		int brickHeight = 20;

		for(int i=0; i<columns; i++) {
			for(int j=0; j<rows; j++) {
				brick = new Rectangle(50+x, y, brickWidth, brickHeight);
				x += 60;
				
				if (bricks.bricks[i][j] > 0){
					if (new Rectangle(ballX,ballY, 15, 15).intersects(brick)){
						bricks.bricks[i][j] = 0;
						
						if(ballX > brickHeight || ballX <= brickHeight) {
							dirY = -dirY;
							dirX = -dirX;
						}
						if(ballY > brickWidth || ballY <= brickWidth){
							dirX = -dirX;
							
						}
					}
				}else {
					x = 60;
					continue;
				}
				
			}
			x = 0;
			y+=30;
		}
		
	
		
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






