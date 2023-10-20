import processing.core.*;
import processing.event.MouseEvent;

public class FlappyApp extends PApplet {

	// represents a FlappyWorld instance
    FlappyWorld f;
    
    // init window size
    public void settings() {
        this.size(600, 600);
    }

    // init world objects including: FlappyWorld, Ball, and Racket
    public void setup() {
    	f = new FlappyWorld(new Ball(400, 200, 15, 1, 0), new Paddle(80, 10, this.mouseX, this.mouseY), new Walls());
    }

    // Draws every object on the screen
    public void draw() {
    	f = f.update();
    	f.draw(this);  // Call the draw method of FlappyWorld 	
    }
    
    
    public void mouseMoved(MouseEvent mev) {
        f = f.mouseMoved(mev);
    }
    

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FlappyApp" }, new FlappyApp());
    }
}


