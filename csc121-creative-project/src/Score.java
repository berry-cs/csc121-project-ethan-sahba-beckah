import processing.core.PApplet;
import processing.core.PFont;

public class Score {
	int score;
	PFont ScoreFont;
	
	public Score() {
		score = 0;
	}
	
	public void increment() {
		score++;
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean isMultipleOfTen() {
        return score > 0 && score % 10 == 0;
    }
	
	public void draw(PApplet p) {
		p.fill(0);
		ScoreFont = p.createFont("Serif", 20);
		p.textFont(ScoreFont);
		p.textSize(20);
		p.text("Score: " + score, 10, 30);
	}
}
