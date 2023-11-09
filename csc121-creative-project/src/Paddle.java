import processing.core.PApplet;

/**
 * Every paddle has a height and a width
 */
public class Paddle {
	int paddleWidth;         
	int paddleHeight;
	int mX;                   // mouse X position
    int mY;                   // mouse Y position
	
	public Paddle(int paddleWidth, int paddleHeight, int mX, int mY) {
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;
		this.mX = mX;
        this.mY = mY;
	}
	
	/**
	 * Draws the paddle on screen
	 */
	public void draw(PApplet p) {
        p.fill(33, 97, 140);
        p.rect(mX - paddleWidth / 2, mY - paddleHeight / 2, paddleWidth, paddleHeight, 15); 
    }
    
	
}