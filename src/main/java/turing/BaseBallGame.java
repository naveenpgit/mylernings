package turing;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiConsumer;

public class BaseBallGame {
	public static void main(String[] args) {
		System.out.println(calPoints(new String[] { "5", "2", "C", "D", "+" }));
		System.out.println(calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
		System.out.println(calPoints(new String[] { "1" }));
	}

	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		Arrays.stream(ops).forEach(s -> operate.accept(s, stack));
		return stack.stream().mapToInt(Integer::intValue).sum();
	}

	static BiConsumer<String, Stack<Integer>> operate = (s, stack) -> {
		switch (s) {
		case "+":
			int _1 = stack.pop();
			int _2 = stack.pop();
			stack.push(_2);
			stack.push(_1);
			stack.push(_1 + _2);
			break;
		case "D":
			int top = stack.peek();
			stack.push(2 * top);
			break;
		case "C":
			stack.pop();
			break;
		default:
			stack.push(Integer.valueOf(s));
		}
	};
}
