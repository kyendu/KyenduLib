package kyendulib.gfx;

public class Color {

	private int color;
	
	public Color(int hex) {
		this.color = hex;
	}
	
	public Color(int r, int g, int b) {
		this.color = getHex(r, g, b);
	}
	
	public int[] getRGB() {
		return getRGB(color);
	}
	
	public static int[] getRGB(int hex) {
		int r = (hex >> 16) & 0xff;
		int g = (hex >> 8) & 0xff;
		int b = (hex) & 0xff;
		return new int[] { r, g, b };
	}
	
	public static int[] getRGBA(int hex) {
		int a = (hex >> 24) & 0xff000000;
		int r = (hex >> 16) & 0xff;
		int g = (hex >> 8) & 0xff;
		int b = (hex) & 0xff;
		return new int[] { a, r, g, b };
	}
	
	public static int getHex(int r, int g, int b) {
		return r << 16 | g << 8 | b;
	}
	
	public static int getHex(int r, int g, int b, int a) {
		return a << 24 | r << 16 | g << 8 | b;
	}
	
	public int getColor() {
		return color;
	}
	
}