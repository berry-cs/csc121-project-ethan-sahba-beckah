import processing.core.PApplet;
import processing.event.MouseEvent;

// Every FlappyWorld has a background color
public class FlappyWorld {
	Ball b;																// Represents the ball
	Paddle p;															// Represents the paddle
	Wall w;																// Represents the walls
	WallManager wm;														// Represents the WallManager
	

    public FlappyWorld(Ball b, Paddle p, Wall w, WallManager wm) {
    	this.b = b;
    	this.p = p;
    	this.w = w;
    	this.wm = wm;
    }
    
    /*
     * Draws all the objects in the FlappyWorld
     */
    public PApplet draw(PApplet b) {
        b.background(193, 225, 240);
        this.b.draw(b);
        this.p.draw(b);
        this.w.draw(b);
        this.wm.draw(b);
        return b;
    }
  
    
    /*
     * Create a new Paddle instance with updated position based on mouse movement
     */
    public FlappyWorld mouseMoved(MouseEvent mev) {
        Paddle updatedPaddle = new Paddle(p.paddleWidth, p.paddleHeight, mev.getX(), mev.getY());
        return new FlappyWorld(b, updatedPaddle, w, wm);
    }
    
    /*
     * Updates the FlappyWorld instance
     */
    public FlappyWorld update() {
    	this.b.Gravity();
    	this.b.onScreen();
    	this.wm.moveWalls();
    	return this;
    }
	
   
}