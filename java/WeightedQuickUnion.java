public class WeightedQuickUnion {
	private int[] grid;
	private int[] size;

	public WeightedQuickUnion(int N) {
		grid = new int[N];
		size = new int[N];
		for(int i = 0; i < N; i++) {
			grid[i] = i;
			size[i] = 1;
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
			int rootSecond = root(grid[second]);
			// Set size of size[newRoot] to (size[gridChangedElement] + 1) only when (size[gridChangedElement] + 1) > size[newRoot]
			if (size[rootFirst] <= size[rootSecond]) {
				grid[rootFirst] = rootSecond;
				if (size[rootFirst] + 1 > size[rootSecond]) {
					size[rootSecond] = size[rootFirst] + 1;
				}
			} else {
				grid[rootSecond] = rootFirst;
				if (size[rootSecond] + 1 > size[rootFirst]) {
					size[rootFirst] = size[rootSecond] + 1;
				}
			}
		}
		display();
	}

	public void display() {
		System.out.print("posn\t");
		for (int i = 0; i < grid.length; i++) {
			System.out.print(i);
			if (i != grid.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("grid\t");
		for (int i = 0; i < grid.length; i++) {
			System.out.print(grid[i]);
			if (i != grid.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.print("size\t");
		for (int i = 0; i < size.length; i++) {
			System.out.print(size[i]);
			if (i != size.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {
		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		int f = 0, s = 5;
		wqu.union(f, s);

		f = 5;
		s = 6;
		wqu.union(f, s);

		f = 1;
		s = 2;
		wqu.union(f, s);

		f = 1;
		s = 7;
		wqu.union(f, s);

		f = 3;
		s = 4;
		wqu.union(f, s);

		f = 8;
		s = 9;
		wqu.union(f, s);

		f = 4;
		s = 8;
		wqu.union(f, s);

		f = 2;
		s = 3;
		wqu.union(f, s);

		System.out.println("Are " + f + " and " + s + " connected? " + wqu.isConnected(f, s));
		f = 1;
		f = 5;
		wqu.union(f, s);
		System.out.println("Are " + f + " and " + s + " connected? " + wqu.isConnected(f, s));
	}
}

