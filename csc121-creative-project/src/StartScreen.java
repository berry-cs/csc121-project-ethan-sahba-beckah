import processing.core.PApplet;
import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class StartScreen implements IWorld {
	
	/*
	 * X & Y for the title
	 */
	float x;
    float y; 				
    
    /*
     * X & Y for the "press space" message
     */
    float x2;
    float y2;
    
    float yOffset = 0;						 // Offset for the vertical bounce
    float angle = 0; 						 // Angle for the sine wave
    float amplitude = 10; 					 // Amplitude of the bounce
    
    PFont startF;

    @Override
    public PApplet draw(PApplet c) {
    	c.background(100,188,140);
        c.fill(0);
        startF = c.createFont("FlappyBirdy.ttf", 150, true);

        yOffset = amplitude * PApplet.sin(angle); 				// Calculate the vertical offset using a sine wave
        angle += 0.05; 											// Adjust the speed of the bounce by changing the increment
        y = 200 + yOffset;
        
        c.textFont(startF);
        c.textSize(150);
        c.text("FlappyPong", x, y);
    
        c.textSize(50);
        c.text("Press space to start", x2, y2);
        
        return c;
    }

    @Override
    public IWorld update() {
        x = 95;
        x2 = 150;
        y2 = 400;
        return this;
    }

    @Override
    public IWorld mouseMoved(MouseEvent mev) {
        return this;
    }

    @Override
    public IWorld keyPressed(KeyEvent kev) {
        if (kev.getKey() == ' ') {
            return new FlappyWorld(new Ball(100, 200, 15, 1, 3), 
                    new Paddle(80, 10, 200, 200), 
                    new Wall(600, 0, 50, 100, 15), new WallManager());
        } else {
            return this;
        }
    }

}
