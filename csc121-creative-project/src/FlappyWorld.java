import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

// Every FlappyWorld has a background color
public class FlappyWorld implements IWorld {
	Ball b;																// Represents the ball
	Paddle p;															// Represents the paddle
	Wall w;																// Represents the walls
	WallManager wm;														// Represents the WallManager
	Score s;
	

    public FlappyWorld(Ball b, Paddle p, Wall w, WallManager wm) {
    	this.b = b;
    	this.p = p;
    	this.w = w;
    	this.wm = wm;
    	this.s = new Score();
    }
    
    /*
     * Draws all the objects in the FlappyWorld
     */
    public PApplet draw(PApplet b) {
        b.background(133, 193, 233);
        this.b.draw(b);
        this.p.draw(b);
        this.w.draw(b);
        this.wm.draw(b);
        s.displayScore(b);
        return b;
    }
  
    /*
     * Create a new Paddle instance with updated position based on mouse movement
     */
    public IWorld mouseMoved(MouseEvent mev) {
        Paddle updatedPaddle = new Paddle(p.paddleWidth, p.paddleHeight, mev.getX(), mev.getY());
        return new FlappyWorld(b, updatedPaddle, w, wm);
    }
    
    /*
     * Updates the FlappyWorld instance
     */
    public IWorld update() {
    	this.b.Gravity();
    	this.b.onScreen();
    	this.b.checkPaddleCollision(p);
    	this.wm.moveWalls();
    	
    	//this.b.bounce(this.p);   // check if ball hit paddle and make it bounce if so
    	
    	return this;
    }

    public IWorld keyPressed(KeyEvent kev) {
        if (kev.getKey() == ' ') {
            this.b.boost(30);
            return new FlappyWorld(this.b, this.p, this.w, this.wm);
        } else {
            return this;
        }
    }
	
   
}