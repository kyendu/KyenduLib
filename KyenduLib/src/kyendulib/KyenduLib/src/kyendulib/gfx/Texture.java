package kyendulib.gfx;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import kyendulib.error.KyenduError;

public class Texture {

	public int width;
	public int height;
	
	public int[] pixels;
	public int[] pixelsRGB;
	
	public static final int FORMAT_RGB = 0x0;
	public static final int FORMAT_RGBA = 0x1;
	
	public Texture(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}
	
	public static Texture load(String path) {
		int width = 0;
		int height = 0;
		int[] pixels = null;
		try {
			BufferedImage image = ImageIO.read(new FileInputStream(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch(IOException e) {
			new KyenduError("An IOException has occured", Texture.class);
		}
		
		return new Texture(width, height, pixels);
	} 
	
	public int[] getPixels(int format) {
		if(format == FORMAT_RGBA) {
			return pixels;
		}
		
		if(pixelsRGB != null) {
			return pixelsRGB;
		}
		
		pixelsRGB = new int[width * height];
		
		for(int i = 0; i < width * height; i++) {
			int r = (pixels[i] & 0xff0000) >> 16;
			int g = (pixels[i] & 0xff00) >> 8;
			int b = (pixels[i] & 0xff);
			pixelsRGB[i] = r << 16 | g << 8 | b;
		}
		
		return pixelsRGB;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}