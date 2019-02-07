package kyendulib.interfaces;

import kyendulib.gfx.Bitmap;

public interface BitmapObject {

	public int getWidth();
	public int getHeight();
	public int[] getPixels();
	public void render(int x, int y, Bitmap screen);

}