import processing.core.PApplet;
import processing.event.KeyEvent;


// Every FlappyWorld has a background color
public class FlappyWorld implements IWorld {
	Bird b;																// Represents the ball
	WallManager wm;
	Score s;
	Wall w;
	public boolean isGameOver;

	
	
    public FlappyWorld(Bird b, WallManager wm, Score s) {
    	this.b = b;
    	this.wm = wm;
    	this.s = s;
    }
    
    /*
     * Draws all the objects in the FlappyWorld
     */
    public PApplet draw(PApplet b) {
        	b.background(91, 134, 194);
            this.b.draw(b);
            this.wm.draw(b);
            this.s.draw(b); 
		return b;
    }
    
    /*
     * Updates the FlappyWorld instance
     */
    public IWorld update() {
    	this.b.gravity();
    	this.wm.updateWalls(b, s);
    	gameover();
    	if (isGameOver) {
    		return new GameoverScreen(this.s);
    	} else {
    		return this;
    	}
    }

    /*
     * Checks if the user pressed space as well as it checks that isGameOver is not true.
     */
    public IWorld keyPressed(KeyEvent kev) {
    	if (kev.getKey() == ' ' && !isGameOver) {
            this.b.boost(-7);
            Sound.flapSound();
            return new FlappyWorld(this.b, this.wm, this.s);
        } 
    	else {
    		return this;
    	}
    }
    
    /*
     * Checks if the bird hits the ground or the walls
     */
    public void gameover() {
    	if (this.b.hitsGround()) {
            isGameOver = true;
            Sound.deathSound();
        }
    	
    	for (Wall wall : WallManager.walls) {
            if (this.b.collidesWith(wall)) {
                isGameOver = true;
                Sound.deathSound();
                break;
            }
        }
    }
   
}