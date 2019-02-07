package kyendulib;

public class State {

	private static final int MENU = 0x0;
	private static final int GAME = 0x1;
	public static int state = GAME;
	
	public static void setState(int state) {
		State.state = state;
		
		if(state == 0) {
			state = MENU;
		}
		
		if(state == 1) {
			state = GAME;
		}
	}
	
	public static int getState() {
		return state;
	}
}