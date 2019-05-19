package problemSolving;

import java.util.Stack;

public class ParenthesisBalance {

	public static void main(String[] args) {

		char exp[] = { '{', '(', '(', '}', '[', ']' };

		System.out.println(isParenthesisBalanced(exp));
	}

	private static boolean isParenthesisBalanced(char[] exp) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < exp.length; i++) {
			if (exp[i] == '{') {
				stack.push('}');
			} else if (exp[i] == '(') {
				stack.push(')');
			} else if (exp[i] == '[') {
				stack.push(']');
			} 
			else if (!stack.isEmpty() && stack.pop() != exp[i]) {
				return false;
			}
		}

		return true;
	}

}
