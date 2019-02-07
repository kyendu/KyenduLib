package kyendulib;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import kyendulib.interfaces.Playable;
import kyendulib.interfaces.Renderable;

public abstract class Game extends Canvas implements Playable, Runnable {
	private static final long serialVersionUID = 1L;
	
	protected BufferStrategy bs;
	protected Graphics g;
	
	public void drawBuffer(LinkedList<Renderable> buffer) {
		for(int i = 0; i < buffer.size(); i++) {
			buffer.get(i).render(g);
		}
		
		buffer.clear();
	}
	
}