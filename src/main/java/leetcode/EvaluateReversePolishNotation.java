package leetcode;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Integer.valueOf;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();

		Arrays.stream(tokens).forEach(x -> {
			switch (x) {
			case "+":
				int a = valueOf(stack.pop());
				int b = valueOf(stack.pop());
				stack.push(a + b);
				break;
			case "-":
				a = valueOf(stack.pop());
				b = valueOf(stack.pop());
				stack.push(b - a);
				break;
			case "*":
				a = valueOf(stack.pop());
				b = valueOf(stack.pop());
				stack.push(a * b);
				break;
			case "/":
				a = valueOf(stack.pop());
				b = valueOf(stack.pop());
				stack.push(b / a);
				break;
			default:
				stack.push(valueOf(x));
			}
		});
		int res = stack.pop();
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {

		EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
		evaluateReversePolishNotation.evalRPN(new String[] { "2", "1", "+", "3", "*" });
		evaluateReversePolishNotation.evalRPN(new String[] { "4", "13", "5", "/", "+" });
		evaluateReversePolishNotation.evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" });
	}
}
