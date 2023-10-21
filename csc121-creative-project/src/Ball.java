import processing.core.PApplet;
/** 
 * Every ball has a bX (ball x pos), bY (ball y pos), size, gravity, 
 * and a verticle speed
 */
public class Ball {
	double bX;
    double bY;
    int size;
    double gravity;
    double vSpeed;
    
    public Ball(double bX, double bY, int size, double gravity, double vSpeed) {
    	this.bX = bX;
    	this.bY = bY;
    	this.size = size;
    	this.gravity = gravity;
    	this.vSpeed = vSpeed;
    
    }
    
    /*
     * Draws the ball
     */
    public PApplet draw(PApplet b) {
        b.fill(0, 0, 255);
        b.circle((float) this.bX, (float) this.bY, this.size);
        return b;
    }
    
    
    /*
     * Keeps the ball from falling through the edges
     */
    public void onScreen() {
    	if (bY + (size / 3) > 600) {
    		floorCol(600);
    	}
    	
    	if (bY - (size / 3) < 0) {
    		ceilingCol(0);
    	}
    	
    }
    
    /*
     * Applies collision to the ball on the floor
     */
    public void floorCol(double f) {
    	bY = f - (size / 3);
    	vSpeed *= -0.5;
    }
    
    /*
     * Applies collision to the ball on the ceiling
     */
    public void ceilingCol(double c) {
    	bY = c + (size / 3);
    	vSpeed *= -0.5;
    }
    
    /*
     * Applies gravity to the ball
     */
    public void Gravity() {
    	vSpeed += gravity;
    	bY += vSpeed;
    }
    
}
