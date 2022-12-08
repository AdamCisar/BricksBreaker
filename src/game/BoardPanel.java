package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
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
	int x;

	
	BoardPanel(){
		paddle = new Paddle(150);
		this.setPreferredSize(BOARD_SIZE);
		this.addKeyListener(new Key());
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
		
		paddle.draw(g);
//		g.dispose();
		
		Toolkit.getDefaultToolkit().sync(); 
	}


	
	private class Key implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		paddle.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
		
	}
}






