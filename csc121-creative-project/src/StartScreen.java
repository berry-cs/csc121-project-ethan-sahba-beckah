import processing.core.PApplet;
import processing.core.*;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class StartScreen implements IWorld {

	float x;
    float y; // Y-coordinate for the text position
    float yOffset = 0; // Offset for the vertical bounce
    float angle = 0; // Angle for the sine wave
    float amplitude = 10; // Amplitude of the bounce
    PFont startF;
    PFont anotherFont;

    @Override
    public PApplet draw(PApplet c) {
        c.background(120);
        c.fill(0);

        // Calculate the vertical offset using a sine wave
        yOffset = amplitude * PApplet.sin(angle);
        angle += 0.05; // Adjust the speed of the bounce by changing the increment

        // Update the Y-coordinate for the text position
        y = 200 + yOffset;
        
        c.textFont(startF);
        c.text("Flappy", x, y);
        c.textFont(anotherFont);
        c.text("Pong", x + 10, y + 40);

        return c;
    }

    @Override
    public IWorld update() {
        x = 180;
        return this;
    }

    @Override
    public IWorld mouseMoved(MouseEvent mev) {
        return this;
    }

    @Override
    public IWorld keyPressed(KeyEvent kev) {
        if (kev.getKey() == ' ') {
            return new FlappyWorld(new Ball(400, 200, 15, 1, 0), 
                    new Paddle(80, 10, 0, 0), 
                    new Wall(600, 0, 50, 100, 15), new WallManager());
        } else {
            return this;
        }
    }

}
