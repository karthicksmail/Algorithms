public class GenericArrayStack<DataType> {
	private DataType[] stack;
	private int top;

	public GenericArrayStack() {
		stack = (DataType[]) new Object[1];
		top = 0;
	}

	public void push (DataType elem) {
		if (top == stack.length) {
			DataType[] newStack = (DataType[]) new Object[stack.length * 2];
			for (int i = 0; i < stack.length; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		stack[top] = elem;
		top++;
	}

	public DataType pop() {
		DataType elem = (DataType) stack[--top];
		stack[top] = null;
		if (top > 0 && top == stack.length / 4 ) { 
			DataType[] newStack = (DataType[]) new Object[stack.length / 2];
			for (int i = 0; i <= top; i++) {
				newStack[i] = stack[i];
			}
			stack = newStack;
		}
		return elem;
	}

	public boolean isEmpty() {
		return (top == 0);
	}

	public static void main(String[] args) {
		GenericArrayStack<String> arrayStack = new GenericArrayStack<String>();
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

		while(arrayStack.isEmpty() == false) {
			System.out.println(arrayStack.pop());
		}
	}
}

