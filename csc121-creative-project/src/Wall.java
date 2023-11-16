import processing.core.PApplet;

public class Wall {
	float x;
	float gapY;
	float gapHeight;
	float width;
	float speed;
	boolean scoreCounted;
	
	public Wall(float startX, float startGapY, float gapH, float width, float wallSpeed) {
        this.x = startX;
        this.gapY = startGapY;
        this.gapHeight = gapH;
        this.width = width;
        this.speed = wallSpeed;
        scoreCounted = false;
    }
	
	/*
	 * Draws the walls onscreen
	 */
	public void draw(PApplet p) {
		p.fill(104, 161, 143);
		p.noStroke();
		p.rect(x, 0, width, gapY, 10);												//top wall
        p.rect(x, gapY + gapHeight, width, p.height - (gapY + gapHeight), 10);		//bottom wall
	}
	
	/*
	 * Applies movement to the walls so that they move left across the screen
	 */
	public void move() {
		x -= speed;
	}
	
	/*
	 * Determines whether or not wall is off screen
	 */
	public boolean isOffScreen() {
		return x + width < 0;
	}
	
}