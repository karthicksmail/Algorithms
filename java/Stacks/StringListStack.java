public class StringListStack {
	private class Node {
		private String data;
		private Node next;
	}

	private Node top = null;

	public void push(String data) {
		Node elem = new Node();
		elem.data = data;
		elem.next = top;
		top = elem;
	}

	public String pop() {
		Node elem = top;
		top = top.next;
		return elem.data;
	}

	public void displayStack() {
		for (Node elem = top; elem != null; elem = elem.next) {
			System.out.print(elem.data);
			if (top == elem) { 
				System.out.println("\t<-- top");
			} else {
				System.out.println();
			}
		}
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public static void main(String[] args) {
		StringListStack listStack = new StringListStack();
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

		listStack.displayStack();
		System.out.println("===================================");

		while(listStack.isEmpty() == false) {
			System.out.println(listStack.pop());
		}
	}
}

