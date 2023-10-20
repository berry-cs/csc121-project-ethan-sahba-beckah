import processing.core.PApplet;
import processing.event.MouseEvent;

// Every FlappyWorld has a background color
public class FlappyWorld {
	Ball b;
	Paddle p;
	Walls w;

    public FlappyWorld(Ball b, Paddle p, Walls w) {
    	this.b = b;
    	this.p = p;
    	this.w = w;
    }
    
    // initializes the background/window
    public PApplet draw(PApplet b) {
        b.background(193, 225, 240);
        this.b.draw(b);
        this.update();
        this.p.draw(b);
        return b;
    }
  
    
    public FlappyWorld mouseMoved(MouseEvent mev) {
        // Create a new Paddle instance with updated position based on mouse movement
        Paddle updatedPaddle = new Paddle(p.paddleWidth, p.paddleHeight, mev.getX(), mev.getY());
        return new FlappyWorld(b, updatedPaddle, w);
    }
    
    
    public FlappyWorld update() {
    	this.b.Gravity();
    	this.b.onScreen();
    	this.w.moveWalls();
    	return this;
    }

   
}

