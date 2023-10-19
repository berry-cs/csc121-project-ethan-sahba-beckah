import processing.core.PApplet;
import java.util.*;

class Wall {
    float x;
    float openingY;
    float wallWidth;
    float wallHeight;
    float speed;

    public Wall(float x, float openingY, float wallWidth, float wallHeight, float speed) {
        this.x = x;
        this.openingY = openingY;
        this.wallWidth = wallWidth;
        this.wallHeight = wallHeight;
        this.speed = speed;
    }

    /*
     * Draws the walls
     */
    public void draw(PApplet p) {
        p.fill(0, 0, 0); 																// Set the color of the walls
        p.rect(x, 0, wallWidth, openingY); 												// Upper wall
        p.rect(x, 600, wallWidth, p.height - openingY - wallHeight); 					// Lower wall
    }

    /*
     * Moves the walls
     */
    public void move() {
        x -= speed;
    }

    /*
     * Checks if walls are off screen
     */
    public boolean isOutOfScreen() {
        return x + wallWidth < 0;								// If x + wallWidth is less than 0, returns true
    }
}

public class Walls {
    private ArrayList<Wall> walls;
    private float wallSpacing = 300; 							// Adjust this value to control the gap between each new wall
    private float lastWallX = 600; 								// Initial position of the first wall

    Random rand = new Random();									// Initialize random()

    public Walls() {
        walls = new ArrayList<>();
        genWalls();
    }

    /*
     * Generates walls
     */
    public void genWalls() {
        for (int i = 0; i < 100; i++) {  						                                       // Adjust the number of walls as needed
            float gapHeight = rand.nextInt(-300, 100); 												   // Define the gap height (openingY)
            Wall topWall = new Wall(lastWallX, 0, 60, gapHeight, 2); 								   // Top wall with adjusted gapHeight
            Wall bottomWall = new Wall(lastWallX, gapHeight + 100, 60, 600 - gapHeight - 100, 2);      // Bottom wall
            walls.add(topWall);
            walls.add(bottomWall);
            lastWallX += wallSpacing; 																   // Adjust wall spacing as needed
        }
    }

    /*
     * Draws the walls and moves them on screen
     */
    public void moveAndDraw(PApplet p) {
        for (int i = 0; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            wall.move();
            wall.draw(p);
            if (wall.isOutOfScreen()) {
                float openingY = rand.nextInt(-300, 100);
                Wall newWall = new Wall(lastWallX, 100, 40, openingY, 2);
                walls.set(i, newWall);
                lastWallX += wallSpacing;
            }
        }
    }
}