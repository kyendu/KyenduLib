package kyendulib.ui;

import java.awt.Color;
import java.awt.Graphics;

import kyendulib.interfaces.Clickable;

public class UIButton extends UIObject {

	public Color color = Color.white;
	public Color hoveringColor = Color.red;
	
	private String text;
	private Clickable clicker;
	
	public UIButton(String text, float x, float y, int width, int height, Clickable clicker) {
		super(x, y, width, height);
		this.text = text;
		this.clicker = clicker;
	}
	
	@Override
	public void tick() {
			
	}
	
	@Override
	public void render(Graphics g) {
		if(hovering) {
			g.setColor(hoveringColor);
			g.drawRect((int)x, (int)y, width, height);
			g.drawString(text, (int)x, (int)y);
		} else {
			g.setColor(color);
			g.drawRect((int)x, (int)y, width, height);
			g.drawString(text, (int)x, (int)y);
		}
	}
	
	@Override
	public void onClick() {
		clicker.onClick();
	}
	
}