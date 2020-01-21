package coinJar;
import java.util.Random;
public class Die {
	private static String difficulty;
	private static int[] outcomes;
	private static int rollSize;
	
	public Die() {
		difficulty = "normal";
		outcomes = new int[6];
		for(int i=0;i<=5;i++) {
			outcomes[i]=i+1;
		}
	}
	
	public Die(int diff) {
		//Easy Difficulty: Probability of rolling a 6 is 2/7
		if(diff==0) {
			difficulty = "easy";
			int[] temp = {6,1,2,3,4,5,6};
			outcomes = temp;
			rollSize=7;
			//outcomes= {6,1,2,3,4,5,6};
		} 
		//Normal Difficulty: Probability of rolling a 6 is 1/6
		else if(diff==1) {
			difficulty = "normal";
			int[] temp = {1,2,3,4,5,6};
			outcomes = temp;
			rollSize=6;
			
		} 
		//Hard Difficulty: Probability of rolling a 6 is 1/11
		else {
			difficulty = "hard";
			int[] temp = {1,2,3,4,5,1,2,3,4,5,6};
			outcomes = temp;
			rollSize=11;
		}
	}
	public void print() {
		System.out.println("Die outcomes:");
		for(int x:outcomes) {
			System.out.print(x+", ");
		}
		System.out.println();
	}
	public int roll() {
		Random r = new Random();
		int num = r.nextInt(getRollSize());
		return outcomes[num];

	}
	public String getDifficulty() {
		return difficulty;
	}

	public static int getRollSize() {
		return rollSize;
	}


}
