import processing.core.*;
import processing.event.*;

public class FlappyApp extends PApplet {

	// represents a FlappyWorld instance
    IWorld f;
    
    // init window size
    public void settings() {
        this.size(600, 600);
    }

    // init world objects including: FlappyWorld, Ball, Paddle, Wall, and WallManager
    public void setup() {
    	f = new StartScreen();
    }

    // Draws objects on the screen
    public void draw() {
    	f.draw(this);  // Call the draw method of FlappyWorld 
    	f = f.update();
    }
    
    public void keyPressed(KeyEvent kev) {
        f = f.keyPressed(kev);
    }
    

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FlappyApp" }, new FlappyApp());
    }
}

