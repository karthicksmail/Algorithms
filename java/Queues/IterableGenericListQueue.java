import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableGenericListQueue<T> implements Iterable<T> {
	private class Node {
		T data;
		Node next;
	}

	private Node first, last;

	public void enqueue(T data) {
		Node elem = new Node();
		elem.data = data;
		elem.next = null;
		if (first == null) {
			first = elem;
		}
		if (last == null) {
			last = elem;
		} else {
			last.next = elem;
			last = elem;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Node elem = first;
		first = first.next;
		elem.next = null;
		return elem.data;
	}

	public void display() {
		for (Node elem = first; elem != null; elem = elem.next) {
			System.out.print(elem.data);
			if (last == elem) {
				System.out.println("\t<--last");
			} else if (first == elem) {
				System.out.println("\t<--first");
			} else {
				System.out.println();
			}
		}
		System.out.println("=======================");
	}

	private boolean isEmpty() {
		return (first == null);
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<T> {
		public boolean hasNext() {
			return (first != null);
		}

		public T next() {
			return dequeue();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public static void main(String[] args) {
		IterableGenericListQueue<Integer> integerQueue = new IterableGenericListQueue<Integer>();
		integerQueue.enqueue(Integer.valueOf(1));
		integerQueue.enqueue(Integer.valueOf(2));
		integerQueue.enqueue(Integer.valueOf(3));
		integerQueue.enqueue(Integer.valueOf(4));
		integerQueue.enqueue(Integer.valueOf(5));

		// integerQueue.display();

		Iterator<Integer> i = integerQueue.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();

		System.out.println("----------------------------------------------------------------------------");

		IterableGenericListQueue<String> stringQueue = new IterableGenericListQueue<String>();
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

		// stringQueue.display();

		for(String s:stringQueue) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}

