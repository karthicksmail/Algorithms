public abstract class Sort{
	protected Comparable[] array;
	protected int swapCount;
	protected int compareCount;

	protected void title() {
	}

	protected void initialize(Comparable[] array) {
		this.array = array;
		this.swapCount = 0;
		this.compareCount = 0;
	}

	protected void swap(int i, int j) {
		//System.out.println("Swapping " + ((Person)array[i]).getAge() + " and " + ((Person)array[j]).getAge());
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

