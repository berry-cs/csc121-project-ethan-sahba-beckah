import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.event.KeyEvent;

public class GameoverScreen implements IWorld {
	public boolean isGameOver = false;

	/*
	 * x and y values for the text on screen.
	 */
	float x, y;
	float x2, y2;
	
	PFont FlappyFont;
	PFont GameoverFont;
	
	@Override
	public IWorld update() {
		x = 100;
		x2 = 160;
		y2 = 400;
		return this;
	}
	
	@Override
	public PApplet draw(PApplet c) {
		c.background(91, 134, 194);
		c.fill(0);
		FlappyFont = c.createFont("FlappyBirdy.ttf", 150, true);
		GameoverFont = c.createFont("Serif", 20, true);
		c.textAlign(PConstants.CENTER);
		
		c.textFont(FlappyFont);
		c.textSize(150);
		
		c.text("Game Over", 300, 270);
		
		c.textSize(50);
		c.text("Press space to retry", 300, 350);
		
		c.textSize(20);
		c.textFont(GameoverFont);
		c.text("Highscore: " , 300, 430);
		
		return c;
	}
	
	@Override
	public IWorld keyPressed(KeyEvent kev) {
	    if (kev.getKey() == ' ' && isGameOver) {
	    	System.out.println("ur pressing space.");
	    	return new FlappyWorld(new Ball(100, 200, 10), 
					new WallManager(50, 120, 2), 
					new Score());
	    } else {
	        return this;
	    }
	}


}
