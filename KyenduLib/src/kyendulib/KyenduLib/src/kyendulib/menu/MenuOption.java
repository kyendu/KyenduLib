package kyendulib.menu;

import java.awt.Color;

import kyendulib.interfaces.Action;

public class MenuOption {

	private String title;
	private Action action;
	
	public static Color color = Color.white;
	public static Color selectedColor = Color.red;
	
	public MenuOption(String title, Action action) {
		this.title = title;
		this.action = action;
		MenuOption.color = Color.white;
		MenuOption.selectedColor = Color.red;
	}
	
	public void trigger() {
		if(action != null) {
			action.trigger();
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Color getColor() {
		return color;
	}

	public static void setColor(Color color) {
		MenuOption.color = color;
	}

	public Color getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(Color selectedColor) {
		MenuOption.selectedColor = selectedColor;
	}
	
}