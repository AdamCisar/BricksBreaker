package game;

import javax.swing.JFrame;

public class BoardFrame extends JFrame{

	BoardPanel panel;
	
	BoardFrame(){
		panel = new BoardPanel();
		this.add(panel);
		this.setTitle("Bricks Breaker");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
