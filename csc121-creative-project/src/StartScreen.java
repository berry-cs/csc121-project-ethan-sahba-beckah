import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class StartScreen implements IWorld {

    float x; 
    
    @Override
    public PApplet draw(PApplet c) {
        c.background(120);
        c.fill(0);
        c.text("Press space to start", x, 200);
        return c;
    }

    @Override
    public IWorld update() {
        x += Math.random() * 2;
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
