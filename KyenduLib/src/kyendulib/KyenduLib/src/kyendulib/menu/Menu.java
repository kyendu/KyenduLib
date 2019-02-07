package kyendulib.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import kyendulib.Game;

public class Menu {

	private MenuOption[] options;
	private Color background;
	private Game game;
	public static Font font;
	
	private int currentSelection = 0;
	
	public Menu(MenuOption[] options, Color background) {
		this.options = options;
		this.background = background;
		Menu.font = new Font("Helvetica", Font.PLAIN, 20);
	}
	
	public Menu(MenuOption[] options, Color background, Font font) {
		this.options = options;
		this.background = background;
		if(font == null) {
			Menu.font = new Font("Helvetica", Font.PLAIN, 20);			
		} else {
			Menu.font = font;
		}
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void render(int x, int y, Graphics g) {
		g.setColor(background);
		g.fillRect(0, 0, game.getWidth(), game.getHeight());
		for(int i = 0; i < options.length; i++) {
			if(i == currentSelection) {
				g.setColor(options[i].getSelectedColor());
			} else {
				g.setColor(options[i].getColor());
			}
			
			g.setFont(font);
			g.drawString(options[i].getTitle(), x, y + i * 44);
		}
	}
	
	public void keyPressed(int key) {
		if(key == KeyEvent.VK_DOWN) {
			currentSelection++;
			if(currentSelection >= options.length) {
				currentSelection = 0;
			}
		} else if(key == KeyEvent.VK_UP) {
			currentSelection--;
			if(currentSelection < 0) {
				currentSelection = options.length - 1;
			}
		}
		
		if(key == KeyEvent.VK_ENTER) {
			options[currentSelection].trigger();
		}
	}
	
	public void keyReleased(int key) {
		
	}
}