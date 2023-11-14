import processing.core.PApplet;

public class Score {
	int score;
	
	public Score() {
		score = 0;
	}
	
	public void increment() {
		score++;
	}
	
	public int getScore() {
		return score;
	}
	
	public void draw(PApplet p) {
		p.fill(0);
		p.textSize(32);
		p.text("Score: " + score, 10, 30);
	}
}
