import processing.core.PApplet;

public class Ball {
    float x, y;          // Position of the ball
    float velocityY;     // Vertical velocity of the ball
    float gravity;       // Gravity affecting the ball
    float radius;        // Radius of the ball
    int height = 600;


    public Ball(float startX, float startY, float startRadius) {
        x = startX;
        y = startY;
        radius = startRadius;
        velocityY = 0;
        gravity = 0.5f;  // Adjust this value to change the gravity's strength
        
    }

    /*
     * Update the balls gravity and position
     */
    public void gravity() {
        velocityY += gravity;								 // Gravity increases the downward velocity
        y += velocityY;      								 // Update the vertical position

        // Prevent the ball from going off the screen
        if (y > height - radius) {
            y = height - radius;
            velocityY = 0;
        }
    }

    /*
     * Draw the ball on screen
     */
    public void draw(PApplet p) {
        p.fill(52, 46, 55);  // Set the color of the ball
        p.noStroke();
        p.imageMode(p.CENTER);
        p.image(p.loadImage("birds.png"), (float) x, (float) y);
        //p.ellipse(x, y, radius * 2, radius * 2);
    }
    
    /*
     * This applies boost to the ball, making it move upward
     */
    public void boost(int b) {
        velocityY = b; 											// Adjust this value to change the boost strength
    }
    
    /*
     * Keeps the ball from falling off the screen
     */
    public boolean hitsGround() {
        return y + radius >= height;
    }
    
    /*
     * Checks if the ball touches a wall
     */
    public boolean collidesWith(Wall wall) {
        return (x + radius > wall.x && x - radius < wall.x + wall.width) &&
               ((y - radius < wall.gapY) || (y + radius > wall.gapY + wall.gapHeight));
    }
    
}
