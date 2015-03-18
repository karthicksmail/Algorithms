import java.util.Iterator;

public class IterableGenericListStack<DataType> implements Iterable<DataType>{
	private class Node {
		DataType data;
		Node next;
	}

	private Node top = null;

	public void push(DataType data) {
		Node elem = new Node();
		elem.data = data;
		elem.next = top;
		top = elem;
	}

	public DataType pop() {
		Node elem = top;
		top = top.next;
		return elem.data;
	}

	public Iterator<DataType> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<DataType> {
		public boolean hasNext() {
			return (top != null);
		}

		public DataType next() {
			return pop();
		}

		public void remove() { /* Unimplemented */ }
	}

	public static void main(String[] args) {
		IterableGenericListStack<Integer> integerStack = new IterableGenericListStack<Integer>();
		integerStack.push(Integer.valueOf(1));
		integerStack.push(Integer.valueOf(2));
		integerStack.push(Integer.valueOf(3));
		integerStack.push(Integer.valueOf(4));
		integerStack.push(Integer.valueOf(5));

		Iterator<Integer> i = integerStack.iterator();
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
		System.out.println();

		System.out.println("----------------------------------------------------------------------------");

		IterableGenericListStack<String> stringStack = new IterableGenericListStack<String>();
		stringStack.push("\b!!");
		stringStack.push("better");
		stringStack.push("be");
		stringStack.push("will");
		stringStack.push("tomorrow");
		stringStack.push("But");
		stringStack.push("\b!");
		stringStack.push("day");
		stringStack.push("great");
		stringStack.push("a");
		stringStack.push("is");
		stringStack.push("It");

		for(String s:stringStack) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
}

