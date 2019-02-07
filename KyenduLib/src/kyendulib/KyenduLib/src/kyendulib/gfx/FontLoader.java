package kyendulib.gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import kyendulib.error.KyenduError;

public class FontLoader {

	public static Font loadFont(String path, float size) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(size);
		} catch (FontFormatException e) {
			new KyenduError("A FontFormatException has occured", FontLoader.class).show();
		} catch (IOException e) {
			new KyenduError("An IOException has occured", FontLoader.class).show();
		}
		
		return null;
	}
}