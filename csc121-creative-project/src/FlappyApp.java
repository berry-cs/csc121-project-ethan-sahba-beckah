import processing.core.*;
import processing.event.*;

public class FlappyApp extends PApplet {

	// represents a FlappyWorld instance
    IWorld f;
    IWorld g;
    
    // init window size
    public void settings() {
        this.size(600, 600);
    }

    // init world objects including: FlappyWorld, Ball, Paddle, Wall, and WallManager
    public void setup() {
    	f = new StartScreen();
    	g = new GameoverScreen();
    }

    // Draws objects on the screen
    public void draw() {
    	f.draw(this);  // Call the draw method of FlappyWorld 
    	f = f.update();
    	g = g.update();
    }
    
    
    public void keyPressed(KeyEvent kev) {
        f = f.keyPressed(kev);
        g = g.keyPressed(kev);
    }
    

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FlappyApp" }, new FlappyApp());
    }
}

