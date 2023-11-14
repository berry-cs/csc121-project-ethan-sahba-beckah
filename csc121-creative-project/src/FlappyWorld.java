import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

// Every FlappyWorld has a background color
public class FlappyWorld implements IWorld {
	Ball b;																// Represents the ball
	WallManager wm;
	Score s;
	Wall w;
	public boolean isGameOver;
	IWorld g = new GameoverScreen();
	
	
    public FlappyWorld(Ball b, WallManager wm, Score s) {
    	this.b = b;
    	this.wm = wm;
    	this.s = s;
    }
    
    /*
     * Draws all the objects in the FlappyWorld
     */
    public PApplet draw(PApplet b) {
        if (!isGameOver) {
        	b.background(151, 122, 225);
            this.b.draw(b);
            this.wm.draw(b);
            this.s.draw(b);
            
            if (this.b.hitsGround()) {
                isGameOver = true;
            }

            for (Wall wall : WallManager.walls) {
                if (this.b.collidesWith(wall)) {
                    isGameOver = true;
                    break;
                }
            }
            
            
        } else {
        	return g.draw(b);
        }
        
		return b;
    }
    
    /*
     * Updates the FlappyWorld instance
     */
    public IWorld update() {
    	this.b.gravity();
    	this.wm.updateWalls(b, s);
    	return this;
    }

    public IWorld keyPressed(KeyEvent kev) {
    	if (kev.getKey() == ' ') {
            this.b.boost(-7);
            return new FlappyWorld(this.b, this.wm, this.s);
        } else {
            return this;
        }
    }
    
   
}