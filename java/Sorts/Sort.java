/**
 * Abstract class for all sort algorithms.
 */
public abstract class Sort{
	protected Comparable[] array;
	protected int swapCount;
	protected int compareCount;

	/**
	 * Initialize the member variables.
	 * @param array - An array of elements to be sorted.
	 */
	protected void initialize(Comparable[] array) {
		this.array = array;
		this.swapCount = 0;
		this.compareCount = 0;
	}

	/**
	 * Swap the elements in the specified positions in the array.
	 * @param i - The position of an element to be swapped in the internal data structure.
	 * @param j - The position of an element to be swapped in the internal data structure.
	 */
	protected void swap(int i, int j) {
		//System.out.println("Swapping " + ((Person)array[i]).getAge() + " and " + ((Person)array[j]).getAge());
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		swapCount++;
	}

	/**
	 * Abstract method that is overridden to display the name of the sort algorithm that is implemented.
	 */
	protected abstract void title();

	/**
	 * Abstract method which is overridden to provide the sort functionality.
	 */
	public abstract void sort();

	/**
	 * Display the metrics at the end of the sort. Currently, we consider the number of compares and the number of swaps as valid metrics.
	 */
	public void displayMetrics() {
		System.out.println("Number of Compares = " + compareCount);
		System.out.println("Number of Swaps = " + swapCount);
	}
}

