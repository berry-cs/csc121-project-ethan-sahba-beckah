import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Score {
	int score;
	PFont ScoreFont;
	
	public Score() {
		score = 0;
	}
	
	/*
	 * Increments the score by 1
	 */
	public void increment() {
		score++;
	}
	
	/*
	 * Returns the score
	 */
	public int getScore() {
		return score;
	}
	
	/*
	 * Checks if the score is a multiple of 10
	 */
	public boolean isMultipleOfTen() {
        return score > 0 && score % 10 == 0;
    }
	
	/*
	 * Displays score on screen
	 */
	public void draw(PApplet p) {
		p.fill(0);
		ScoreFont = p.createFont("Serif", 20);
		p.textFont(ScoreFont);
		p.textSize(20);
		p.textAlign(PConstants.LEFT);
		p.text("Score: " + score, 10, 30);
	}
}
