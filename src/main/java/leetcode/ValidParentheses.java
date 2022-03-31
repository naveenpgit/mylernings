package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		final Stack<Character> stack = new Stack<>();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i++);
			if (isOpen(c))
				stack.push(c); //open bracket push to stack
			else {
				boolean valid = !stack.isEmpty() &&
						isPreviousOneIsOpenOfSameType(stack.peek(), c); // close one should be of same type tht is open most recently
				if (valid)
					stack.pop();
				else
					return false; //most recent open bracket is not of same type then break
			}
		}
		return stack.isEmpty();
	}

	private boolean isPreviousOneIsOpenOfSameType(char top, char curr) {
		switch (curr) {
		case ')':
			return top == '(';
		case ']':
			return top == '[';
		case '}':
			return top == '{';
		}
		return false;
	}

	boolean isOpen(char c) {
		return c == '(' || c == '[' || c == '{';
	}

	public static void main(String[] args) {
		ValidParentheses validParentheses = new ValidParentheses();
		System.out.println(validParentheses.isValid("()"));
		System.out.println(validParentheses.isValid("()[]{}"));
		System.out.println(validParentheses.isValid("(]"));
		System.out.println(validParentheses.isValid("([)]"));
		System.out.println(validParentheses.isValid("]"));
	}
}
