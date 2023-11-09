import processing.core.PApplet;
import processing.core.PFont;

public class Score {
    private int score;
    
    PFont serif;

    public Score() {
        this.score = 0;
    }

    public void increaseScore() {
        this.score++;
    }

    public int getScore() {
        return this.score;
    }

    public void displayScore(PApplet p) {
        p.fill(0);
        p.textSize(40);
        serif = p.createFont("SourceCodePro-Semibold.otf", 20, true);
        p.textFont(serif);
        p.text("Score " + getScore(), 20, 30); // Use getScore() to dynamically retrieve the current score
    }
}


/*
 * Score is currently not working, I'm trying to figure out how to incorporate two fonts because it doesn't
 * really like the flappy bird font for whatever reason.
 */
