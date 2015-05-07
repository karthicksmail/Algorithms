public class ShellSort extends Sort {
	public void title() {
		System.out.println("Using Shell Sort");
		System.out.println("================");
	}

	private int findH(int length) {
		return length / 2;
	}

	public void sort() {
		int h = array.length;
		while (h > 1) {
			h = findH(h);
			for (int i = 0; i + h < array.length; i+=h) {
				compareCount++;
				int retval = array[i].compareTo(array[i + h]);
				if (retval == 1) {
					swap(i, i + h);
				}
			}
		}
	}
}

