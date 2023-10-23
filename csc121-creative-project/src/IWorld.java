import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public interface IWorld {
	public PApplet draw(PApplet c);
	public IWorld update();
	public IWorld mouseMoved(MouseEvent mev);
	public IWorld keyPressed(KeyEvent kev);
}
