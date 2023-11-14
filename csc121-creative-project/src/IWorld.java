import processing.core.PApplet;
import processing.event.KeyEvent;

public interface IWorld {
	public PApplet draw(PApplet c);
	public IWorld update();
	public IWorld keyPressed(KeyEvent kev);
}
