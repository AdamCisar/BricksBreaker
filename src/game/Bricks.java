package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Bricks {

	public int bricks[][];
	
	public int brickX = 0;
	public int brickY = 0;
	
	public int columns = 5;
	public int row = 5;
	
	
	Bricks(){
		createBricks();
	}
	
	
	
	public void createBricks() {
		bricks = new int[row][columns];
		for(int i=0; i<columns; i++) {
			for(int j=0; j<row; j++) {
				bricks[i][j] = 1;
			}
		
		}
		
	}

	
	public void draw(Graphics g) {
		
		int x = 0;
		int y = 30;
		
		for(int i=0; i<columns; i++) {
			for(int j=0; j<row; j++) {
				
				if(bricks[i][j] > 0){
				g.setColor(Color.orange);
				g.fillRect(50+x, y, 50, 20);
				x += 60;
				}
			}
			x = 0;
			y+=40;
		}
			
		}
		
		
		
	

}
