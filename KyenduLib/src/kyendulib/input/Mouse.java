package kyendulib.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Mouse extends MouseAdapter {

	public boolean[] buttons = new boolean[Integer.MAX_VALUE];
	public static int button = -1;
	private static int x;
	private static int y;
	public int action = 0;
	public int actionExtension = 0;
	
	private double scale = 1.0;
	
	public Mouse() {
		
	}
	
	public Mouse(double scale) {
		this.scale = scale;
	}
	
	public synchronized void mouseClicked(MouseEvent e) {
		if(e.getButton() >= buttons.length) {
			return;
		}
		
		button = e.getButton();
		action = MouseEvent.MOUSE_CLICKED;
		buttons[e.getButton()] = true;
	}

	public synchronized void mouseEntered(MouseEvent e) {
		action = MouseEvent.MOUSE_ENTERED;
	}

	public synchronized void mouseExited(MouseEvent e) {
		action = MouseEvent.MOUSE_EXITED;
	}

	public synchronized void mousePressed(MouseEvent e) {
		if(e.getButton() >= buttons.length) {
			return;
		}
		
		button = e.getButton();
		buttons[e.getButton()] = true;
		action = MouseEvent.MOUSE_PRESSED;
	}

	public synchronized void mouseReleased(MouseEvent e) {
		if(e.getButton() >= buttons.length) {
			return;
		}
		
		button = e.getButton();
		buttons[e.getButton()] = true;
		action = MouseEvent.MOUSE_RELEASED;
	}

	public synchronized void mouseWheelMoved(MouseWheelEvent e) {
		action = MouseWheelEvent.WHEEL_UNIT_SCROLL;
		actionExtension = MouseWheelEvent.WHEEL_BLOCK_SCROLL;
	}

	public synchronized void mouseDragged(MouseEvent e) {
		x = (int)(e.getX() / scale / scale);
		y = (int)(e.getY() / scale / scale);
		action = MouseEvent.MOUSE_DRAGGED;
	}

	public synchronized void mouseMoved(MouseEvent e) {
		x = (int)(e.getX() / scale / scale);
		y = (int)(e.getY() / scale / scale);
		action = MouseEvent.MOUSE_MOVED;
	}
	
	public static boolean buttonDown(int button) {
		return Mouse.button == button;
	}

	public static int getButton() {
		return button;
	}
	
	public static int getX() {
		return x;
	}
	
	public static int getY() {
		return y;
	}
	
	public int getAction() {
		return action;
	}
	
	public int getActionExtension() {
		return actionExtension;
	}
	
	public boolean[] getButtons() {
		return buttons;
	}
	
	public boolean mouseButtonDown(int button) {
		return buttons[button];
	}
	
	public double getScale() {
		return scale;
	}
	
	public void setScale(double scale) {
		this.scale = scale;
	}
	
}