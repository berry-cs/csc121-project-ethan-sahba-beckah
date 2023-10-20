import processing.core.PApplet;

/**
 * Every paddle has a height and a width
 */
public class Paddle {
	int paddleWidth;
	int paddleHeight;
	int mouseX;
    int mouseY;
	
	public Paddle(int paddleWidth, int paddleHeight, int mouseX, int mouseY) {
		this.paddleWidth = paddleWidth;
		this.paddleHeight = paddleHeight;
		this.mouseX = mouseX;
        this.mouseY = mouseY;
	}
	
	/**
	 * Draws the paddle on screen, centers it with the mouse, and also has it
	 * track the mouse so that the paddle is always following
	 */
	public void draw(PApplet p) {
        p.fill(0, 0, 0);
        p.rect(mouseX - paddleWidth / 2, mouseY - paddleHeight / 2, paddleWidth, paddleHeight, 15); 
    }
	
}
