import processing.core.PApplet;
import processing.core.PConstants;

/**
 * Every paddle has a height and a width
 */
public class Paddle {
	int paddleWidth;
	int paddleHeight;
	
	public Paddle(int paddleWidth, int paddleHeight) {
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;
	}
	
	/**
	 * Draws the paddle on screen, centers it with the mouse, and also has it
	 * track the mouse so that the paddle is always following
	 */
	public PApplet draw(PApplet p) {
		p.fill(0, 0, 0);
		p.rect(p.mouseX, p.mouseY, paddleWidth, paddleHeight, 15); 
		p.rectMode(PConstants.CENTER); // centers the paddle with the mouse
		return p; 
	}	
	
}
