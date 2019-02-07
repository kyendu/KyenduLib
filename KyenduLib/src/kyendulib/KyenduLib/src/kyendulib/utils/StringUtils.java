package kyendulib.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import kyendulib.error.KyenduError;

public class StringUtils {

	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) {
				builder.append(line + "\n");
			}
			br.close();
		}catch(IOException e){
			new KyenduError("An IOException has occured", StringUtils.class).show();;
		}		
		return builder.toString();
	}
	
}