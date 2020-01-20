package coinJar;

public class Die {
	private double probSix;
	private static int[] outcomes;
	public Die() {
		probSix=1.0;
		outcomes = new int[6];
		for(int i=0;i<=5;i++) {
			outcomes[i]=i+1;
		}
	}
	public Die(int diff) {
		if(diff==0) {
			outcomes = new int[7];
			outcomes[0]=6;
			for(int i=1;i<=5;i++) {
				outcomes[i]=i;
			}
			outcomes[6]=6;
		} 
		else if(diff==1) {
			outcomes = new int[6];
			for(int i=0;i<=5;i++) {
				outcomes[i]=i+1;
			}
		} 
		else {
			outcomes = new int[11];
			for(int i=0;i<=9;i++) {
				outcomes[i]=((i)%5)+1;
			}
			outcomes[10]=6;
		}
	}
	public static void print() {
		System.out.println("Die outcomes:");
		for(int x:outcomes) {
			System.out.print(x+", ");
		}
		System.out.println();
	}
}
