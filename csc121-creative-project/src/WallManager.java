import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import processing.core.PApplet;

public class WallManager {
    static ArrayList<Wall> walls;
    float wallWidth;      // Width of the walls
    float gapHeight;      // Height of the gap
    float wallSpeed;      // Speed of the walls
    float timeSinceLastWall; // Time since the last wall was added
    Random rand = new Random();		

    // Constructor
    public WallManager(float wallW, float gapH, float speed) {
        walls = new ArrayList<Wall>();
        wallWidth = wallW;
        gapHeight = gapH;
        wallSpeed = speed;
        timeSinceLastWall = 0;
    }

    // Update all wall pairs
    public void updateWalls(Ball ball, Score score) {
        timeSinceLastWall++;

        // Check if it's time to add a new wall
        if (timeSinceLastWall > 150) { // Adjust this value for wall spawning frequency
            addWall();
            timeSinceLastWall = 0;
        }

        // Update each wall pair
        Iterator<Wall> iter = walls.iterator();
        while (iter.hasNext()) {
            Wall wall = iter.next();
            wall.move();

            // Remove the wall if it is off screen
            if (wall.isOffScreen()) {
                iter.remove();
            }
        }
        
        for (Wall wall : WallManager.walls) {
            if (ball.x > wall.x + wall.width && !wall.scoreCounted) {
                score.increment();
                wall.scoreCounted = true; // Add a boolean flag in WallPair to ensure score is counted only once per wall
            }
        }
        
    }

    // Draw all wall pairs
    public void draw(PApplet p) {
        for (Wall wall : walls) {
            wall.draw(p);
        }
    }

    // Add a new wall pair
    private void addWall() {
        // Calculate a random gap start position
        float gapStart = rand.nextFloat(100, 600 - 100 - gapHeight); // Adjust range as needed

        // Add a new wall pair to the list
        walls.add(new Wall(600, gapStart, gapHeight, wallWidth, wallSpeed));
    }
}
