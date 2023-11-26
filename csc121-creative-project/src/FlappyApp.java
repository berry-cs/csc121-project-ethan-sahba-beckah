import processing.core.*;
import processing.event.*;
import processing.sound.*;

public class FlappyApp extends PApplet {

	/*
	 * Represents a FlappyWorld instance
	 */
    IWorld f;
    
    /*
     * Initialize window size
     */
    public void settings() {
        this.size(600, 600);
    }

    /*
     * Initializes world objects including: FlappyWorld, Ball, Paddle, Wall, and WallManager
     * Also loads sounds
     */
    public void setup() {
    	f = new StartScreen();
    	loadSound();
    }

    /*
     * Draws objects on the screen
     */
    public void draw() {
    	f.draw(this);  // Call the draw method of FlappyWorld 
    	f = f.update();
    }
    
    /*
     * Handles key presses
     */
    public void keyPressed(KeyEvent kev) {
        f = f.keyPressed(kev);
    }
    
    /*
     * Loads all the sounds into the game
     */
    public void loadSound() {
    	Sound.flapSound = new SoundFile(this, "sounds/flap.mp3");
    	Sound.deathSound = new SoundFile(this, "sounds/die.mp3");
    	Sound.scoreSound = new SoundFile(this, "sounds/score.wav");
    }
    
    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FlappyApp" }, new FlappyApp());
    }
    
}

