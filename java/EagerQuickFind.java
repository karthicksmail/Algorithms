public class EagerQuickFind {
	private int[] grid;
	public EagerQuickFind(int N){
		grid = new int[N];
		for (int i = 0; i < N; i++) {
			grid[i] = i;
		}
	}

	public boolean isConnected(int first, int second) {
		return (grid[first] == grid[second]);
	}

	public void union(int first, int second){
		if (isConnected(first, second)) {
			return;
		} else {
			int orig_sec = grid[second];
			for (int i = 0; i < grid.length; i++) {
				if (grid[i] == orig_sec) {
					grid[i] = grid[first];
				}
			}
		}
		display();
	}

	public void display() {
		for (int i = 0; i < grid.length; i++) {
			System.out.print(grid[i]);
			if (i != grid.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		EagerQuickFind eqf = new EagerQuickFind(10);
		int f = 0, s = 5;
		eqf.union(f, s);

		f = 5;
		s = 6;
		eqf.union(f, s);

		f = 1;
		s = 2;
		eqf.union(f, s);

		f = 1;
		s = 7;
		eqf.union(f, s);

		f = 3;
		s = 4;
		eqf.union(f, s);

		f = 8;
		s = 9;
		eqf.union(f, s);

		f = 4;
		s = 8;
		eqf.union(f, s);

		System.out.println("Are " + f + " and " + s + " connected? " + eqf.isConnected(f, s));
		f = 1;
		System.out.println("Are " + f + " and " + s + " connected? " + eqf.isConnected(f, s));
		eqf.union(1, 5);
		f = 5;
		System.out.println("Are " + f + " and " + s + " connected? " + eqf.isConnected(f, s));
	}
}

