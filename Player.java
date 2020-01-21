package coinJar;

public class Player {

	private static int stash;
	
	public Player(){
		stash=12;
	}
	
	public void remove() {
		stash--;
	}
	
	public void add() {
		stash++;
	}
	public void add(int amnt) {
		stash+=amnt;
	}
	
	public int getStash() {
		return stash;
	}
	
}
