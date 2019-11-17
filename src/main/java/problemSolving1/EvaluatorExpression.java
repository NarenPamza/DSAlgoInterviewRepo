package problemSolving1;

import java.util.Stack;

/**
 * 10 + 2 * 6 = 22
 * 
 * "10 + 2 * 6" ---> 22 "100 * 2 + 12" ---> 212 "100 * ( 2 + 12 )" ---> 1400
 * "100 * ( 2 + 12 ) / 14" ---> 100
 *
 */
public class EvaluatorExpression {

	/*
	 * A Java program to evaluate a given expression where tokens are separated
	 * by space. Test Cases: "10 + 2 * 6" ---> 22 "100 * 2 + 12" ---> 212
	 * "100 * ( 2 + 12 )" ---> 1400 "100 * ( 2 + 12 ) / 14" ---> 100
	 */

	/*
	 * 1. Iterate through the char, omit white spaces, 2. check precedence is
	 * there, if yes, apply ops 3. else after putting all values in the stack,
	 * apply ops.
	 */
	public static int evaluate(String expression) {
		char[] tokens = expression.toCharArray();

		Stack<Integer> numbers = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i] == ' ') {
				continue;
			}

			// Insert Numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuilder builder = new StringBuilder();
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					builder.append(tokens[i++]);
				}
				numbers.push(Integer.parseInt(builder.toString()));
			}

			else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			}

			else if (tokens[i] == ')') {
				// solve entire braces
				while (ops.peek() != '(')
					numbers.push(applyOps(ops.pop(), numbers.pop(), numbers.pop()));
				ops.pop();
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
				while (!ops.isEmpty() && hasPredence(tokens[i], ops.peek())) {
					numbers.push(applyOps(ops.pop(), numbers.pop(), numbers.pop()));
				}

				ops.push(tokens[i]);
			}
		}

		while (!ops.isEmpty()) {
			numbers.push(applyOps(ops.pop(), numbers.pop(), numbers.pop()));
		}

		return numbers.pop();
	}

	private static boolean hasPredence(char op1, char ops2) {
		if (ops2 == '(' || ops2 == ')') {
			return false;
		} 
		
		if ((op1 == '*' || op1 == '/') && (ops2 == '+' || ops2 == '-')) {
			return false;
		} else {
			return true;
		}

	}

	private static int applyOps(char op, Integer b, Integer a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	// Driver method to test above methods
	public static void main(String[] args) {
//		System.out.println(EvaluatorExpression.evaluate("1400 / 14"));
		System.out.println(EvaluatorExpression.evaluate("100 * 2 + 12"));
//		System.out.println(EvaluatorExpression.evaluate("100 * ( 2 + 12 )"));
//		System.out.println(EvaluatorExpression.evaluate("100 * ( 17 + 12 ) / 14"));
	}
}
