import processing.core.*;

public class FlappyApp extends PApplet {

	// represents a FlappyWorld instance
    FlappyWorld f;
    
    // represents a Ball instance
    Ball b;
    
    // represents a racket instance
    Paddle p;
    
    Wall[] walls;
    float wallSpacing = 300; // Adjust this value to control the gap between each new wall 
    float lastWallX = 600; // Initial position of the first wall
    
    // init window size
    public void settings() {
        this.size(600, 600);
    }

    // init world objects including: FlappyWorld, Ball, and Racket
    public void setup() {
    	f = new FlappyWorld();
    	b = new Ball(400, 200, 15, 1, 0);
        p = new Paddle(80, 10);
        
        // Generates a given number of walls into a list
        walls = new Wall[100]; // Adjust the number of walls as needed
        for (int i = 0; i < walls.length; i++) {
            float openingY = random(100, height - 100);           // Adjust openingY range as needed
            walls[i] = new Wall(lastWallX, 100, 40, openingY, 2); // Adjust wallWidth, wallHeight, and speed as needed
            lastWallX += wallSpacing;                             // Adjust wall spacing as needed
        }
        
    }

    // Draws every object on the screen
    public void draw() {
    	f.draw(this);  // Call the draw method of FlappyWorld
    	b = b.update();
    	b.draw(this);
    	p.draw(this);
    	
    	// Renders the walls from the generated list of walls
    	for (int i = 0; i < walls.length; i++) {
            walls[i].move();
            walls[i].draw(this);
            if (walls[i].isOutOfScreen()) {
            	float openingY = random(100, height - 100); 
                walls[i] = new Wall(lastWallX, 100, 40, openingY, 2); 
                lastWallX += wallSpacing; 
            }
        }
    	
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FlappyApp" }, new FlappyApp());
    }
}


