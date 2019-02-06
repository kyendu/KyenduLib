package kyendulib.input;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class Keyboard extends MouseAdapter {

	public boolean[] key = new boolean[Integer.MAX_VALUE];
	
	public synchronized void keyPressed(KeyEvent e) {
		if(e.getKeyCode() >= key.length) {
			return;
		}
		
		key[e.getKeyCode()] = true;
	}
	
	public synchronized void keyReleased(KeyEvent e) {
		if(e.getKeyCode() >= key.length) {
			return;
		}
		
		key[e.getKeyCode()] = false;
	}
	
}
