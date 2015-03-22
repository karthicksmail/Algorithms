public class InsertionSort extends Sort {
	public void title() {
		System.out.println("Using Insertion Sort");
		System.out.println("====================");
	}

	public void sort() {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				int retval = array[min].compareTo(array[j]);
				compareCount++;
				if (retval == 1) {
					min = j;
				}

				//for (int k = 0; k < array.length; k++) {
				//	((Person)array[k]).display();
				//	if(min == k) {
				//		System.out.println("\t\tmin above this");
				//	}
				//}
			}
			swap(i, min);
		}
	}
}

