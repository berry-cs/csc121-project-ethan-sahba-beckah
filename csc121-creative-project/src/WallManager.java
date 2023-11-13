import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class WallManager {
    ArrayList<Wall> walls;										// Initialize the ArrayList for walls
    private float wallSpacing = 300; 							// Adjust this value to control the gap between each new wall
    private float lastWallX = 600; 								// Initial position of the first wall
    
    Random rand = new Random();									// Initialize random()

    public WallManager() {
        walls = new ArrayList<>();
        genWalls();
    }

    /*
     * Generates the walls
     */
    public void genWalls() {
        for (int i = 0; i < 999; i++) {																							// For loop that runs 999 times.
        	
        	float gapHeightTop = rand.nextInt(100, 200);
        	float additionalHeight = rand.nextInt(100, 200); // Generate a separate random value
        	
        	Wall topWall = new Wall(lastWallX, 0, 60, gapHeightTop, 2);															// Generates the top wall
        	Wall bottomWall = new Wall(lastWallX, gapHeightTop + 100, 60, 600 - gapHeightTop - 100 + additionalHeight, 2);		// Generates the bottom wall
            
        	walls.add(topWall);
            walls.add(bottomWall);
            lastWallX += wallSpacing;
        }
    }
    
    /*
     * Moves the walls
     */
    public void moveWalls(Ball ball, Score score) {
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.move();																							// Calls the move function from Walls.java
            
            if (score.shouldScore(wall, ball)) {
                score.increaseScore();
                wall.setScored(true);
            }
            
            if (wall.isOffScreen()) {																				// Checks if wall is off screen and generates a new one
                float openingY = rand.nextInt(-300, 100);
                Wall newWall = new Wall(lastWallX, 100, 40, openingY, 2);
                walls.set(i, newWall);
                lastWallX += wallSpacing;
            }
            
        }
    }
    
    /*
     * Draws the walls
     */
    public void draw(PApplet p) {
    	for (Wall wall : walls) {
    		wall.draw(p);
    	}
    }
    
    
}