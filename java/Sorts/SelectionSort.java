public class SelectionSort extends Sort {
	public void title() {
		System.out.println("Using Selection Sort");
		System.out.println("====================");
	}

	public void sort() {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int retval = array[i].compareTo(array[j]);
				compareCount++;
				if (retval ==  1) {
					swap(i, j);
				}
			}
		}
	}
}

