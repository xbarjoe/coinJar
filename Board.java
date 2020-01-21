package coinJar;

public class Board {
	private boolean[] slots;

	public Board() {
		slots = new boolean[5];
	}

	public boolean isOccupied(int pos) {
		return slots[pos];
	}

	public int add(int num) {
		System.out.println("DIE RECIEVED INPUT "+num);
		if (num == 6) {
			return 0;
		}
		if (this.isOccupied(num)) {
			return this.clear();
		} else {
			slots[num] = true;
			return 0;
		}

	}

	public int clear() {
		int ret = this.numOccupied();
		for (int i = 0; i <= 5; i++) {
			slots[i] = false;
		}
		return ret;
	}

	public int numOccupied() {
		int count = 0;
		for (int i = 0; i <= 5; i++) {
			if (slots[i] = true) {
				count++;
			}
		}
		return count;
	}
}
