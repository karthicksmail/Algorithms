import java.util.Iterator;

public class IterableGenericArrayQueue<T> implements Iterable<T> {
	private int first, last;
	private T array[];

	public IterableGenericArrayQueue() {
		array = (T[])new Object[1];
	}

	private void resizeArray(int len) {
		T newArray[] = (T[])new Object[len];
		for (int i = 0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}

	private void downsizeArray(int len) {
		T newArray[] = (T[])new Object[len];
		for (int i = 0; i < len; i++) {
			newArray[i] = array[i + first];
		}
		last = last - first;
		first = 0;
		array = newArray;
	}

	public void enqueue(T data) {
		if (last == array.length - 1) {
			resizeArray(array.length * 2);
		}
		array[last++] = data;
	}

	public T dequeue() {
		if ((last - first) == array.length / 4) {
			downsizeArray(array.length / 2);
		}
		T elem = array[first];
		array[first++] = null;
		return elem;
	}

	public Iterator<T> iterator() {
		return new ArrayIterator();
	}

	public void display() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + "\t" + array[i]);
			if (first == i) {
				System.out.println("\t<-- first");
			} else if (last == i) {
				System.out.println("\t<-- last");
			} else {
				System.out.println();
			}
		}
		System.out.println("--------");
	}

	private class ArrayIterator implements Iterator<T>{
		public boolean hasNext() {
			return (array[first] != null);
		}

		public T next() {
			return dequeue();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		IterableGenericArrayQueue<Integer> integerQueue = new IterableGenericArrayQueue<Integer>();
		integerQueue.enqueue(Integer.valueOf(1));
		integerQueue.enqueue(Integer.valueOf(2));
		integerQueue.enqueue(Integer.valueOf(3));
		integerQueue.enqueue(Integer.valueOf(4));
		integerQueue.enqueue(Integer.valueOf(5));
		integerQueue.enqueue(Integer.valueOf(6));
		integerQueue.enqueue(Integer.valueOf(7));
		integerQueue.enqueue(Integer.valueOf(8));
		integerQueue.enqueue(Integer.valueOf(9));
		integerQueue.enqueue(Integer.valueOf(10));
		integerQueue.enqueue(Integer.valueOf(11));
		integerQueue.enqueue(Integer.valueOf(12));
		integerQueue.enqueue(Integer.valueOf(13));
		integerQueue.enqueue(Integer.valueOf(14));
		integerQueue.enqueue(Integer.valueOf(15));
		integerQueue.enqueue(Integer.valueOf(16));
		integerQueue.enqueue(Integer.valueOf(17));
		integerQueue.enqueue(Integer.valueOf(18));
		integerQueue.enqueue(Integer.valueOf(19));
		integerQueue.enqueue(Integer.valueOf(20));

		//integerQueue.display();

		Iterator<Integer> i = integerQueue.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
			//i.next();
			//integerQueue.display();
		}
		System.out.println();

		System.out.println("----------------------------------------------------------------------------");

		IterableGenericArrayQueue<String> stringQueue = new IterableGenericArrayQueue<String>();
		stringQueue.enqueue("It");
		stringQueue.enqueue("is");
		stringQueue.enqueue("a");
		stringQueue.enqueue("great");
		stringQueue.enqueue("day");
		stringQueue.enqueue("\b!");
		stringQueue.enqueue("But");
		stringQueue.enqueue("tomorrow");
		stringQueue.enqueue("will");
		stringQueue.enqueue("be");
		stringQueue.enqueue("better");
		stringQueue.enqueue("\b!!");

		//stringQueue.display();

		for(String s:stringQueue) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}

