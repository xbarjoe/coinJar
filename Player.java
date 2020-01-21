package coinJar;

public class Player {

	private static int stash;
	
	public Player(){
		stash=12;
	}
	
	public static void remove() {
		stash--;
	}
	
	public static void add() {
		stash++;
	}
	public static void add(int amnt) {
		stash+=amnt;
	}
	
	public static int getStash() {
		return stash;
	}
	
}
