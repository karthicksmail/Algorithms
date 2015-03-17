public class GenericListStack<DataType> {
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

	public boolean isEmpty() {
		return (top == null);
	}

	public static void main(String[] args) {
		GenericListStack<String> listStack = new GenericListStack<String>();
		listStack.push("!!");
		listStack.push("better");
		listStack.push("be");
		listStack.push("will");
		listStack.push("tomorrow");
		listStack.push("But");
		listStack.push("!");
		listStack.push("day");
		listStack.push("great");
		listStack.push("a");
		listStack.push("is");
		listStack.push("It");

		while(listStack.isEmpty() == false) {
			System.out.println(listStack.pop());
		}
	}
}

