package kyendulib.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import kyendulib.error.KyenduError;

public class Sprite {

	public static BufferedImage spriteSheet;
	private static final int TILE_SIZE = 32;
	public static int tileSize = TILE_SIZE;
	
	public static BufferedImage loadSprite(String path) {
		BufferedImage sprite = null;
		try {
			sprite = ImageIO.read(new File(path));
		} catch(IOException e) {
			new KyenduError("An IOException has occured", Sprite.class).show();
		}
		
		return sprite;
	}
	
	public static BufferedImage getSprite(int col, int row) {
		if(spriteSheet == null) {
			spriteSheet = loadSprite("AnimationSpriteSheet");
		}
		
		return spriteSheet.getSubimage(col * tileSize, row * tileSize, tileSize, tileSize);
	}
	
}