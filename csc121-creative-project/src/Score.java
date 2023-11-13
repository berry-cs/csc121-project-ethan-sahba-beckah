import processing.core.PApplet;
import processing.core.PFont;

public class Score {
	int score;
	private boolean scored;
	PFont serif;
	
	public Score() {
		this.score = 0;
	}
	
	public void increaseScore() {
		score++;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public boolean shouldScore(Wall wall, Ball ball) {
        return !wall.isScored() && ball.bX > wall.x + (wall.wallWidth / 2);
    }
	
	public void displayScore(PApplet p) {
		p.fill(0);
		p.textSize(15);
		serif = p.createFont("Serif", 20, true);
		p.textFont(serif);
		p.text("Score: " + score, 20, 40);
	}
	
}
