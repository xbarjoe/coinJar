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
			outcomes = new int[7];
			rollSize=7;
			outcomes[0]=6;
			for(int i=1;i<=5;i++) {
				outcomes[i]=i;
			}
			outcomes[6]=6;
		} 
		//Normal Difficulty: Probability of rolling a 6 is 1/6
		else if(diff==1) {
			difficulty = "normal";
			outcomes = new int[6];
			rollSize=6;
			for(int i=0;i<=5;i++) {
				outcomes[i]=i+1;
			}
		} 
		//Hard Difficulty: Probability of rolling a 6 is 1/11
		else {
			difficulty = "hard";
			outcomes = new int[11];
			rollSize=11;
			for(int i=0;i<=9;i++) {
				outcomes[i]=((i)%5)+1;
			}
			outcomes[10]=6;
		}
	}
	public void print() {
		System.out.println("Die outcomes:");
		for(int x:outcomes) {
			System.out.print(x+", ");
		}
		System.out.println();
	}
	public static int roll() {
		Random r = new Random();
		int num = r.nextInt(getRollSize()-1);
		return outcomes[num];

	}
	public String getDifficulty() {
		return difficulty;
	}

	public static int getRollSize() {
		return rollSize;
	}


}
