public class StringArrayStack {
	private String[] stack;
	private int top;

	public StringArrayStack() {
		stack = new String[1];
		top = 0;
	}

	public void push(String elem) {
		if (top == stack.length) {
			String[] newStack = new String[stack.length * 2];
			for(int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		stack[top] = elem;
		top++;
	}

	public String pop() {
		String elem = stack[--top];
		stack[top] = null;
		if (top > 0 && top == stack.length / 4) {
			String[] newStack = new String[stack.length / 2];
			for (int i = 0; i <= top; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		return elem;
	}

	public void displayStack() {
		for (int i = 0; i < stack.length; i++) {
			System.out.print(i + "\t" + stack[i]);
			if (top == i) { 
				System.out.println("\t<-- top");
			} else {
				System.out.println();
			}
		}
	}

	public boolean isEmpty() {
		return (top == 0);
	}

	public static void main(String[] args) {
		StringArrayStack arrayStack = new StringArrayStack();
		arrayStack.push("!!");
		arrayStack.push("better");
		arrayStack.push("be");
		arrayStack.push("will");
		arrayStack.push("tomorrow");
		arrayStack.push("But");
		arrayStack.push("!");
		arrayStack.push("day");
		arrayStack.push("great");
		arrayStack.push("a");
		arrayStack.push("is");
		arrayStack.push("It");

		arrayStack.displayStack();
		System.out.println("===================================");

		while(arrayStack.isEmpty() == false) {
			System.out.println(arrayStack.pop());
		}
	}
}

