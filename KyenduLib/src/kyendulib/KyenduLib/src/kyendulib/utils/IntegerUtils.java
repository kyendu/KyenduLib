package kyendulib.utils;

import kyendulib.error.KyenduError;

public class IntegerUtils {

	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch(NumberFormatException e) {
			new KyenduError("A NumberFormatException has occured", IntegerUtils.class).show();
			return 0;
		}
	}
	
}