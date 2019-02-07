package kyendulib.gfx;

import kyendulib.interfaces.BitmapObject;

/**
 * 
 * @author Savlon
 *
 */
public class BitmapSprite implements BitmapObject {

	private int width;
	private int height;
	private int[] pixels;
	
	public BitmapSprite(Texture texture) {
		create(texture);
	}
	
	public BitmapSprite(String path) {
		create(Texture.load(path));
	}
	
	private void create(Texture texture) {
		width = texture.getWidth();
		height = texture.getHeight();
		pixels = texture.getPixels(Texture.FORMAT_RGB);
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void render(int x, int y, Bitmap screen) {
		screen.render(x, y, this);
	}
	
}