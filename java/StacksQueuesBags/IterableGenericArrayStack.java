import java.util.Iterator;

public class IterableGenericArrayStack<DataType> implements Iterable<DataType> {
	private DataType[] stack;
	private int top;

	public IterableGenericArrayStack() {
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

	public Iterator iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<DataType>{
		public void remove() { throw new UnsupportedOperationException(); }

		public boolean hasNext() {
			return (top != 0);
		}

		public DataType next() {
			return pop();
		}

	}

	public static void main(String[] args) {
		IterableGenericArrayStack<String> stringArrayStack = new IterableGenericArrayStack<String>();
		stringArrayStack.push("!!");
		stringArrayStack.push("better");
		stringArrayStack.push("be");
		stringArrayStack.push("will");
		stringArrayStack.push("tomorrow");
		stringArrayStack.push("But");
		stringArrayStack.push("!");
		stringArrayStack.push("day");
		stringArrayStack.push("great");
		stringArrayStack.push("a");
		stringArrayStack.push("is");
		stringArrayStack.push("It");

		Iterator<String> s = stringArrayStack.iterator();
		while(s.hasNext()) {
			System.out.println(s.next());
		}

		IterableGenericArrayStack<Integer> integerArrayStack = new IterableGenericArrayStack<Integer>();
		integerArrayStack.push(0);
		integerArrayStack.push(1);
		integerArrayStack.push(2);
		integerArrayStack.push(3);
		integerArrayStack.push(4);
		integerArrayStack.push(5);
		integerArrayStack.push(6);
		integerArrayStack.push(7);
		integerArrayStack.push(8);
		integerArrayStack.push(9);

		for (Integer i:integerArrayStack) {
			System.out.println(i);
		}
	}
}

