

import org.junit.jupiter.api.Test;

import processing.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

public class FlappyWorldTest {

	
	WallManager wallManager = new WallManager();
	
	// ball objects for onScreen() tests
	Ball ballAboveCeiling = new Ball(300, -10, 15, 1, 0);
	Ball ballBelowFloor = new Ball(300, 610, 15, 1, 0);
	Ball ballWithinBounds = new Ball(300, 300, 15, 1, 0);
	
	// ball object for floorCol() and ceilingCol() tests
	Ball ballFloorCol = new Ball(300, 600, 15, 1, 5);
	Ball ballCeilingCol = new Ball(300, 10, 15, 1, -5);
	
	// ball object for gravity() test
	Ball ballGrav = new Ball(300, 300, 15, 1, 0);
	
	// ball object for move() test
	Wall wallMove = new Wall(300, 100, 60, 200, 2);
	
	// ball objects for isOffScreen() test
	Wall wall1OffScreen = new Wall(300, 100, 60, 200, 2);
    Wall wall2OffScreen = new Wall(-60, 100, 60, 200, 2);
	
	
	
	
	/*
	 * These three tests are for the onScreen method in Ball.java
	 */
	
	
    @Test
    public void testOnScreenAboveCeiling() {
        ballAboveCeiling.onScreen();
        assertEquals(0.0 + (15 / 3), ballAboveCeiling.bY);
    }

    @Test
    public void testOnScreenBelowFloor() {
        ballBelowFloor.onScreen();
        assertEquals(600.0 - (15 / 3), ballBelowFloor.bY);
    }

    @Test
    public void testOnScreenWithinBounds() {
        ballWithinBounds.onScreen();
        assertEquals(300.0, ballWithinBounds.bY);
    }
    
    
    
    /*
     * These tests test ball collision methods within Ball.java
     */
	
	
    @Test
    public void testFloorCol() {
        double originalBY = ballFloorCol.bY;
        double originalVSpeed = ballFloorCol.vSpeed;
        double floor = 600;

        ballFloorCol.floorCol(floor);

        // Verify that bY has been adjusted to be just above the floor
        assertEquals(floor - (15 / 3), ballFloorCol.bY);

        // Verify that vSpeed has been reversed and reduced by a factor
        assertEquals(-originalVSpeed * 0.5, ballFloorCol.vSpeed);
    }

    @Test
    public void testCeilingCol() {
        double originalBY = ballCeilingCol.bY;
        double originalVSpeed = ballCeilingCol.vSpeed;
        double ceiling = 0;

        ballCeilingCol.ceilingCol(ceiling);

        // Verify that bY has been adjusted to be just below the ceiling
        assertEquals(ceiling + (15 / 3), ballCeilingCol.bY);

        // Verify that vSpeed has been reversed and reduced by a factor
        assertEquals(-originalVSpeed * 0.5, ballCeilingCol.vSpeed);
    }
    
    
    
    /*
     * This test tests the gravity method in Ball.java
     */
	
	
    @Test
    public void testGravity() {
        double originalBY = ballGrav.bY;
        double originalVSpeed = ballGrav.vSpeed;
        double gravity = 1;

        ballGrav.Gravity();

        // Verify that vSpeed has increased by the gravity value
        assertEquals(originalVSpeed + gravity, ballGrav.vSpeed);

        // Verify that bY has been adjusted correctly based on the updated vSpeed
        assertEquals(originalBY + ballGrav.vSpeed, ballGrav.bY);
    }
    
    
    
    /*
     * This test tests the genWalls() method in WallManager.java
     */
	
	
    public void testGenWalls() {
        wallManager.genWalls();

        // Verify that the 'walls' list contains the expected number of walls
        assertEquals(999 * 2, wallManager.walls.size());

        // Verify that each generated wall has the correct properties
        for (int i = 0; i < wallManager.walls.size(); i += 2) {
            Wall topWall = wallManager.walls.get(i);
            Wall bottomWall = wallManager.walls.get(i + 1);

            // Verify that the top and bottom walls have the same 'x' coordinate
            assertEquals(topWall.x, bottomWall.x);

            // Verify that the top wall's openingY and bottom wall's openingY are consistent
            assertEquals(bottomWall.openingY - topWall.openingY, 100);

            // Verify that the walls' heights are consistent with the openingY values
            assertEquals(topWall.wallHeight, topWall.openingY);
            assertEquals(bottomWall.wallHeight, 600 - bottomWall.openingY);

            // Verify that the walls have the correct speed
            assertEquals(topWall.speed, 2);
            assertEquals(bottomWall.speed, 2);
        }
        
        
    }
    
    
    
    /*
     * These tests test the move() and isOutOfScreen() methods in Walls.java
     */
	
	
    @Test
    public void testMove() {
        wallMove.move();

        // Verify that the 'x' position has been adjusted correctly
        assertEquals(298.0, wallMove.x);
    }

    @Test
    public void testIsOffScreen() {
        assertFalse(wall1OffScreen.isOffScreen()); // Wall1 is not out of the screen
        assertTrue(wall2OffScreen.isOffScreen());   // Wall2 is out of the screen
    }
    
    
}
