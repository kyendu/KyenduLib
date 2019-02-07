package kyendulib.interfaces;

import java.awt.Graphics;

public interface Playable {

	public void start();
	public void stop();
	
	public void tick();
	public void render(Graphics g);
	
}