package kyendulib.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class UIManager {

	public LinkedList<UIObject> objects = new LinkedList<UIObject>();
	
	public void tick() {
		for(UIObject o: objects) {
			o.tick();
		}
	}
	
	public void render(Graphics g) {
		for(UIObject o: objects) {
			o.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for(UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}
	
	public void addObject(UIObject o) {
		objects.add(o);
	}
	
	public void removeObject(UIObject o) {
		objects.remove(o);
	}

	public LinkedList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(LinkedList<UIObject> objects) {
		this.objects = objects;
	}
	
}