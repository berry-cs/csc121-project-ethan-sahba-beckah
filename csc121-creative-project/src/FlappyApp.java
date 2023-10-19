import processing.core.*;

public class FlappyApp extends PApplet {

	// represents a FlappyWorld instance
    FlappyWorld f;
    
    // represents a Ball instance
    Ball b;
    
    // represents a racket instance
    Paddle p;
    
    // represents a wall instance
    Walls walls;
    
    
    // init window size
    public void settings() {
        this.size(600, 600);
    }

    // init world objects including: FlappyWorld, Ball, and Racket
    
    public void setup() {
    	f = new FlappyWorld();
    	b = new Ball(400, 200, 15, 1, 0);
        p = new Paddle(80, 10);
        walls = new Walls();
    }
    

    // Draws every object on the screen
    public void draw() {
    	f.draw(this);  // Call the draw method of FlappyWorld
    	b = b.update();
    	b.draw(this);
    	p.draw(this);
    	walls.moveAndDraw(this);
    	
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "FlappyApp" }, new FlappyApp());
    }
}


