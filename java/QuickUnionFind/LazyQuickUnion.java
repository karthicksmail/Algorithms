public class LazyQuickUnion {
	private int[] grid;

	public LazyQuickUnion(int N) {
		grid = new int[N];
		for(int i = 0; i < N; i++) {
			grid[i] = i;
		}
	}

	private int root(int elem) {
		if (grid[elem] == elem) {
			return grid[elem];
		} else {
			return root(grid[elem]);
		}
	}

	public boolean isConnected(int first, int second) {
		return (root(first) == root(second));
	}

	public void union(int first, int second) {
		System.out.println("Union of " + first + " and " + second);
		if (isConnected(first, second)) {
			return;
		} else {
			int rootFirst = root(grid[first]);
			grid[rootFirst] = root(grid[second]);
		}
		display();
	}

	public void display() {
		for (int i = 0; i < grid.length; i++) {
			System.out.print(i);
			if (i != grid.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		for (int i = 0; i < grid.length; i++) {
			System.out.print(grid[i]);
			if (i != grid.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		LazyQuickUnion lqu = new LazyQuickUnion(10);
		int f = 0, s = 5;
		lqu.union(f, s);

		f = 5;
		s = 6;
		lqu.union(f, s);

		f = 1;
		s = 2;
		lqu.union(f, s);

		f = 1;
		s = 7;
		lqu.union(f, s);

		f = 3;
		s = 4;
		lqu.union(f, s);

		f = 8;
		s = 9;
		lqu.union(f, s);

		f = 4;
		s = 8;
		lqu.union(f, s);

		f = 2;
		s = 3;
		lqu.union(f, s);

		System.out.println("Are " + f + " and " + s + " connected? " + lqu.isConnected(f, s));
		f = 1;
		System.out.println("Are " + f + " and " + s + " connected? " + lqu.isConnected(f, s));
		f = 5;
		lqu.union(f, s);
		System.out.println("Are " + f + " and " + s + " connected? " + lqu.isConnected(f, s));
	}
}

