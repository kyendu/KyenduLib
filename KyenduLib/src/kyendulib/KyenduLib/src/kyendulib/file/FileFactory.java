package kyendulib.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

public class FileFactory {

	private static String fileName = "";
	private static String fileExtension = "txt";
	private static String encoding = "UTF-8";
	private static LinkedList<String> lines = new LinkedList<String>();
	
	public static void setFileName(String fileName) {
		if(fileName == null) {
			return;
		} else {
			FileFactory.fileName = fileName;
		}
	}
	
	public static void setFileExtension(String fileExtension) {
		if(fileExtension == null) {
			return;
		} else {
			FileFactory.fileExtension = fileExtension;
		}
	}
	
	public static void setEncoding(String encoding) {
		if(encoding == null) {
			encoding = "UTF-8";
			FileFactory.encoding = encoding;
		} else {
			FileFactory.encoding = encoding;
		}
	}
	
	public static void addLine(String line) {
		lines.add(line);
	}
	
	public static void removeLine(String line) {
		lines.remove(line);
	}
	
	public static void create() {
		try {
			Path file = Paths.get(fileName + "." + fileExtension);
			Files.write(file, lines, Charset.forName(encoding));
		} catch (IOException e) {
			// ignore
		}
	}
	
	public static void create(String fileName, String fileExtension) {
		try {
			setFileName(fileName);
			setFileExtension(fileExtension);
			setEncoding("UTF-8");
			Path file = Paths.get(fileName + "." + fileExtension);
			Files.write(file, lines, Charset.forName(encoding));
		} catch (IOException e) {
			// ignore
		}
	}
	
	public static void create(String fileName, String fileExtension, String encoding) {
		try {
			setFileName(fileName);
			setFileExtension(fileExtension);
			setEncoding(encoding);
			Path file = Paths.get(fileName + "." + fileExtension);
			Files.write(file, lines, Charset.forName(encoding));
		} catch (IOException e) {
			// ignore
		}
	}
	
	public static String getFileName() {
		return fileName;
	}
	
	public static String getFileExtension() {
		return fileExtension;
	}
	
	public static String getEncoding() {
		return encoding;
	}
	
	public static LinkedList<String> getLines() {
		return lines;
	}
	
}