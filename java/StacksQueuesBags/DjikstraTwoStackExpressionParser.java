public class DjikstraTwoStackExpressionParser {
	static IterableGenericArrayStack<Integer> valueStack = new IterableGenericArrayStack<Integer>();
	static IterableGenericArrayStack<String> operStack = new IterableGenericArrayStack<String>();

	private static int operate(char oper, int val2, int val1) {
		switch(oper) {
		case '+':
			return val2 + val1;
		case '-':
			return val2 - val1;
		case '*':
			return val2 * val1;
		case '/':
			return val2 / val1;
		}
		return 0;
	}

	private static int parse(String expr) {
		String[] tokens = expr.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("(")) {
				continue;
			} else if (tokens[i].equals("+") ||
					tokens[i].equals("*") ||
					tokens[i].equals("-") ||
					tokens[i].equals("/")) {
				operStack.push(tokens[i]);
			} else if (tokens[i].equals(")")) {
				String oper = operStack.pop();
				Integer secondVal = valueStack.pop();
				Integer firstVal = valueStack.pop();
				Integer ans = operate(oper.charAt(0), secondVal, firstVal);
				valueStack.push(ans);
			} else {
				valueStack.push(Integer.valueOf(tokens[i]));
			}
		}
		return valueStack.pop();
	}

	public static int calculate(String expr) {
		return parse(expr);
	}

	public static void main(String[] args) {
		System.out.println(calculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )" ));
	}
}

