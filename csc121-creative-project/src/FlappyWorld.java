import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

// Every FlappyWorld has a background color
public class FlappyWorld implements IWorld {
	Ball b;																// Represents the ball
	Wall w;																// Represents the walls
	WallManager wm;														// Represents the WallManager
	Score s;
	

    public FlappyWorld(Ball b, Wall w, WallManager wm, Score s) {
    	this.b = b;
    	this.w = w;
    	this.wm = wm;
    	this.s = s;
    }
    
    /*
     * Draws all the objects in the FlappyWorld
     */
    public PApplet draw(PApplet b) {
        b.background(93, 145, 233);
        this.b.draw(b);
        this.w.draw(b);
        this.wm.draw(b);
        this.s.displayScore(b);
        return b;
    }
    
    /*
     * Updates the FlappyWorld instance
     */
    public IWorld update() {
    	
    	this.b.Gravity();
    	this.b.onScreen();
    	this.wm.moveWalls(b, s);
    	
    	return this;
    }

    public IWorld keyPressed(KeyEvent kev) {
        
    	if (kev.getKey() == ' ') {
            this.b.boost(18);
            return new FlappyWorld(this.b, this.w, this.wm, this.s);
        } else {
            return this;
        }
    }
   
}