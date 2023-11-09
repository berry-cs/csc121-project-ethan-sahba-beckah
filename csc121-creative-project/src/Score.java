import processing.core.PApplet;

public class Score {
    private int score;

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
        p.text("Score " + score, 20, 30);
    }
}


/*
 * Score is currently not working, I'm trying to figure out how to incorporate two fonts because it doesn't
 * really like the flappy bird font for whatever reason.
 */
