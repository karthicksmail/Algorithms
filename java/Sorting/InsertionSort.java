public class InsertionSort extends Sort {
	public void title() {
		System.out.println("Using Insertion Sort");
		System.out.println("====================");
	}

	public void sort() {
		for (int i = 1; i < array.length; i++) {
			Comparable val = (Comparable)array[i];
			int j;
			for (j = i - 1, compareCount++; j >= 0 && array[j].compareTo(val) == 1; j--, compareCount++) {
				array[j + 1] = array[j];
				swapCount++;
			}
			array[j + 1] = val;
		}
	}

	public static void main(String[] args) {
		Integer[] arrInt = {34, 1, 30, 7, 32, 35, 35};

		System.out.println("Before Sorting");
		for (int j = 0; j < arrInt.length; j++) {
			System.out.println(arrInt[j]);
		}
		System.out.println("--------------------");

		InsertionSort sort = new InsertionSort();
		sort.initialize(arrInt);
		sort.sort();

		System.out.println("After Sorting");
		for (int j = 0; j < arrInt.length; j++) {
			System.out.println(arrInt[j]);
		}
		sort.displayMetrics();
		System.out.println("*********************");
	}

}

