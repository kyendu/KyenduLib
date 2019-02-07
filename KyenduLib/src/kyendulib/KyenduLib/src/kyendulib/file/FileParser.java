package kyendulib.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {

	private static String path = "";
	private static String text;
	
	
	public static void setPath(String path) {
		FileParser.path = path;
	}
	
	@SuppressWarnings("resource")
	public static void parse() {
		if(path == null) {
			return;
		}
		
		File file = new File(path);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				text = line;
			}
		} catch (IOException e) {
			// ignore
		}
	}
	
	public static String getText() {
		return text;
	}
	
	public static String getPath() {
		return path;
	}
	
}