import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import processing.core.PApplet;

public class WallManager {
    static ArrayList<Wall> walls;
    float wallWidth;      													// Width of the walls
    float gapHeight;      													// Height of the gap
    float wallSpeed;      													// Speed of the walls
    float timeSinceLastWall; 												// Time since the last wall was added
    float initialWallSpeed;
    float wallSpawnFrequency;
    Random rand = new Random();		

    public WallManager(float wallW, float gapH, float speed) {
        walls = new ArrayList<Wall>();
        wallWidth = wallW;
        gapHeight = gapH;
        initialWallSpeed = speed;
        wallSpeed = speed;
        wallSpawnFrequency = 150;
        timeSinceLastWall = 0;
    }

    /*
     * Updates the walls
     */
    public void updateWalls(Ball ball, Score score) {
        timeSinceLastWall++;

        // Check if it's time to add a new wall
        if (timeSinceLastWall > wallSpawnFrequency) { 										// Adjust this value for wall spawning frequency
            addWall();
            timeSinceLastWall = 0;
        }

        // Update each pair of walls
        Iterator<Wall> iter = walls.iterator();
        while (iter.hasNext()) {
            Wall wall = iter.next();
            wall.move();

            // Remove the wall if it is off screen
            if (wall.isOffScreen()) {
                iter.remove();
            }
        }
        
        for (Wall wall : WallManager.walls) {												// If ball passes through the gap, increase the score
            if (ball.x > wall.x + wall.width && !wall.scoreCounted) {
                score.increment();
                wall.scoreCounted = true;
            }
        }
        
        if (score.isMultipleOfTen()) {														// Every ten points it increases the speed and gives the player an extra point
            wallSpeed += 0.5;
            decreaseSpawnFrequency();
            score.increment();
            updateAllWallsSpeed();
        }
        
    }

    /*
     * Draws the walls onscreen
     */
    public void draw(PApplet p) {
        for (Wall wall : walls) {
            wall.draw(p);
        }
    }

    /*
     * Adds a new pair of walls
     */
    private void addWall() {
        
    	// Calculate a random gap start position
        float gapStart = rand.nextFloat(100, 600 - 100 - gapHeight); // Adjust range as needed

        // Add a new wall pair to the list
        walls.add(new Wall(600, gapStart, gapHeight, wallWidth, wallSpeed));
    }
    
    /*
     * Helper method to decrease the wall spawn rate as speed increases
     */
    public void decreaseSpawnFrequency() {
    	 wallSpawnFrequency *= 0.85; // Decrease spawn frequency, adjust as needed
    }
    
    /*
     * Updates the speed for all walls in the list of walls
     */
    private void updateAllWallsSpeed() {
        for (Wall wall : walls) {
            wall.setSpeed(wallSpeed);
        }
    }

    
}
