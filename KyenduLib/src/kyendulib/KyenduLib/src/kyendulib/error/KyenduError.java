package kyendulib.error;

public class KyenduError {

	private String message;
	private Object cls;
	
	public KyenduError(String message, Object cls) {
		this.message = message;
		this.cls = cls;
	}
	
	public void show() {
		System.err.println(message + " : " + cls);
	}
	
}