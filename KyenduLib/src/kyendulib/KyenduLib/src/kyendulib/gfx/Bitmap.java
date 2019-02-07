package kyendulib.gfx;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.LinkedList;

import kyendulib.error.KyenduError;
import kyendulib.interfaces.BitmapObject;
import kyendulib.interfaces.Renderable;
import kyendulib.utils.Colors;

public class Bitmap {

	private int width;
	private int height;
	private int[] pixels;
	
	private double scale = 1.0;
	
	private LinkedList<Renderable> buffer = new LinkedList<Renderable>();
	private Font font = new Font("Helvetica", Font.PLAIN, 20);
	
	public Bitmap(BufferedImage image, double scale) {
		this.width = (int)(image.getWidth() / scale);
		this.height = (int)(image.getHeight() / scale);
		this.scale = scale;
		this.pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	
	public Bitmap(BufferedImage image) {
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	
	public Bitmap(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}
	
	public Bitmap(int width, int height, double scale) {
		this.width = (int)(width / scale);
		this.height = (int)(height / scale);
		this.scale = scale;
		pixels = new int[width * height];
	}
	
	public void clear(Color color) {
		for(int i = 0; i < width * height; i++) {
			pixels[i] = color.getColor();
		}
	}
	
	public void clear() {
		clear(Colors.BLACK);
	}
	
	public void drawString(final String text, final int x, final int y, final Color color) {
		drawString(text, x, y, font, color);
	}
	
	
	public void fillRect(int x, int y, int width, int height, Color color) {
		for(int yy = y; yy < y + height; yy++) {
			for(int xx = x; xx < x + width; xx++) {
				if(xx < 0 || xx >= this.width || y < 0 || y >= this.height) {
					continue;
				}
				
				pixels[xx + yy * this.width] = color.getColor();
			}
		}
	}
	
	public void renderTexture(Texture t, int x, int y) {
		if(t == null) {
			new KyenduError("The texture is null", this).show();
			return;
		}
		
		for(int yy = 0; yy < t.getHeight(); yy++) {
			int yp = yy + y;
			for(int xx = 0; xx < t.getWidth(); xx++) {
				int xp = xx + x;
				if(xp < 0 || xp >= this.width || yp < 0 || yp >= this.height) {
					continue;
				}
				
				pixels[xp + yp * this.width] = t.getPixels(Texture.FORMAT_RGB)[xx + yy * t.getWidth()];
			}
		}
	}
	
	public void render(int x, int y, BitmapObject object) {
		if(object == null) {
			new KyenduError("The BitmapObject is null", this).show();
		}
		
		for(int yy = 0; yy < object.getHeight(); yy++) {
			int yp = yy + y;
			for(int xx = 0; xx < object.getWidth(); xx++) {
				int xp = xx + x;
				if(xp < 0 || xp >= width || yp < 0 || yp >= height) {
					continue;
				}
				
				pixels[xp + yp * width] = object.getPixels()[xx + yy * object.getWidth()];
			}
		}
	}
	
	public void drawString(final String text, final int x, final int y, final Font font, final Color color) {
		buffer.add(new Renderable() {
			public void render(Graphics g) {
				int[] rgb = color.getRGB();
				g.setFont(font);
				g.setColor(new java.awt.Color(rgb[0], rgb[1], rgb[2]));
				g.drawString(text, x, y);
			}
		});
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public double getScale() {
		return scale;
	}
	
	public int[] getPixels() {
		return pixels;
	}
	
	public LinkedList<Renderable> getBuffer() {
		return buffer;
	}
}