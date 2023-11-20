import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;

public class StartScreen implements IWorld {
	
	/*
	 * x and y values for the text on screen.
	 */
	float x, y;
	float x2, y2;
	
	/*
	 * variables for floating text effect.
	 */
	float yOffset = 0;
	float angle = 0;
	float amplitude = 10;
	
	PFont FlappyFont;
	
	/*
	 * Displays start screen text
	 */
	public PApplet draw(PApplet c) {
		c.background(91, 134, 194);
		c.fill(0);
		FlappyFont = c.createFont("FlappyBirdy.ttf", 150, true);
		
		yOffset = amplitude * PApplet.sin(angle);
		angle += 0.05;
		y = 200 + yOffset;
		
		c.textFont(FlappyFont);
		c.textSize(150);
		c.text("FlappyBird", x, y);
		
		c.textSize(50);
		c.text("Press space to start", x2, y2);
		
		return c;
	}

	/*
	 * Updates the x and y of text on screen
	 */
	@Override
	public IWorld update() {
		x = 100;
		x2 = 150;
		y2 = 400;
		return this;
	}

	/*
	 * Handles key presses to return a new instance of flappyworld
	 */
	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ') {
			return new FlappyWorld(new Ball(100, 200, 10), 
									new WallManager(50, 120, 2), 
									new Score());
		} else {
			return this;
		}
	}

}
