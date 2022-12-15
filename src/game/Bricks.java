package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bricks {

	public int bricks[][];
	
	public int brickX = 0;
	public int brickY = 0;
	
	public int columns = 5;
	public int rows = 5;
	
	
	Bricks(){
		createBricks();
	}
	
	
	
	public void createBricks() {
		bricks = new int[rows][columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				bricks[i][j] = 1;
			}
		
		}
		
	}

	
	public void draw(Graphics g) {
		
		int x = 0;
		int y = 30;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				
				if(bricks[i][j] > 0){
				g.setColor(new Color(214, 105, 54));
				g.fillRect(50+x, y, 50, 20);
				x += 60;
				}else {
				g.setColor(Color.black);
				g.fillRect(50+x, y, 50, 20);
				x += 60;
				}
			}
			x = 0;
			y+=30;
		}
			
		}
		
		
		
	

}
