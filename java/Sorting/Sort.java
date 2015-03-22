public abstract class Sort{
	protected Comparable[] array;
	protected int swapCount;
	protected int compareCount;

	protected Sort(Comparable[] array) {
		this.array = array;
		this.swapCount = 0;
		this.compareCount = 0;
	}

	protected void swap(int i, int j) {
		//System.out.print("Swapping ");
		//((Person)array[i]).display();
		//System.out.print(" and ");
		//((Person)array[j]).display();
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		swapCount++;
	}

	public abstract void sort();

	public void displayMetrics() {
		System.out.println("Number of Compares = " + compareCount);
		System.out.println("Number of Swaps = " + swapCount);
	}
}

