import java.util.ArrayList;
import java.util.Collections;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.event.KeyEvent;

public class GameoverScreen implements IWorld {

	private Score score;
	private Integer highScore;
	
	/*
	 * x and y values for the text on screen.
	 */
	float x, y;
	float x2, y2;
	
	PFont FlappyFont;
	PFont GameoverFont;
	private Highscore highScoreManager = new Highscore();
	
	/*
	 * Handles the loading and updating of high scores
	 */
	public GameoverScreen(Score score) {
        this.score = score;
        
        ArrayList<Integer> allScores = highScoreManager.loadScores();
        allScores.add(this.score.getScore());
        
        highScore = Collections.max(allScores);
        highScoreManager.saveScores(allScores);
    }
	
	/*
	 * Handles drawing all the text and such on screen
	 */
	@Override
	public PApplet draw(PApplet c) {
		c.background(91, 134, 194);
		c.fill(0);
		FlappyFont = c.createFont("files/FlappyBirdy.ttf", 150, true);
		GameoverFont = c.createFont("Serif", 20, true);
		c.textAlign(PConstants.CENTER);
		
		c.textFont(FlappyFont);
		c.textSize(150);
		c.text("Game Over", 300, 270);
		
		c.textSize(50);
		c.text("Press space to retry", 300, 350);
		
		c.textSize(20);
		c.textFont(GameoverFont);
		c.text("Your Score: " + score.getScore(), 300, 400);
		c.text("High score: " + highScore, 300, 430);
		
		return c;
	}
	
	/*
	 * Handles new flappy bird instance when space is pressed
	 */
	@Override
	public IWorld keyPressed(KeyEvent kev) {
	    if (kev.getKey() == ' ') {
	    	return new FlappyWorld(new Bird(100, 200, 10), 
					new WallManager(50, 120, 2), 
					new Score());
	    } else {
	        return this;
	    }
	}

	@Override
	public IWorld update() {
		return this;
	}

}
