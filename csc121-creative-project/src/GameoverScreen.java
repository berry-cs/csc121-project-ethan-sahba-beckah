import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;

public class GameoverScreen implements IWorld {
	public boolean isGameOver;
	
	/*
	 * x and y values for the text on screen.
	 */
	float x, y;
	float x2, y2;
	
	PFont FlappyFont;
	
	@Override
	public IWorld update() {
		x = 100;
		x2 = 160;
		y2 = 400;
		return this;
	}
	
	@Override
	public PApplet draw(PApplet c) {
		c.background(239, 204, 149);
		c.fill(0);
		FlappyFont = c.createFont("FlappyBirdy.ttf", 150, true);
		
		c.textFont(FlappyFont);
		c.textSize(150);
		
		c.text("Game Over", 100, 200);
		
		c.textSize(50);
		c.text("Press space to retry", 160, 400);
		
		return c;
	}

	@Override
	public IWorld keyPressed(KeyEvent kev) {
		if (kev.getKey() == ' ') {
			return new FlappyWorld(new Ball(100, 300, 10), 
									new WallManager(50, 120, 2), 
									new Score());
		} else {
			return this;
		}
	}
}
