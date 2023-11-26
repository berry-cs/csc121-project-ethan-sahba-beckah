import processing.core.*;
import processing.event.*;
import processing.sound.*;

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
    	loadSound();
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
    
    /*
     * Loads all the sounds into the game
     */
    void loadSound() {
    	Sound.flapSound = new SoundFile(this, "sounds/flap.mp3");
    	Sound.deathSound = new SoundFile(this, "sounds/die.mp3");
    	Sound.scoreSound = new SoundFile(this, "sounds/score.wav");
    }
}

