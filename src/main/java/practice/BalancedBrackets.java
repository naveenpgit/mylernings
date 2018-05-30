//https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
package practice;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    final static String[][] BRACKETS = {{"(", ")"}, {"{", "}"}, {"[", "]"}};

    public static boolean isBalanced(String expression) {

        Stack<String> stack = new Stack<>();
        for (String s : expression.split("")) {

            if (stack.isEmpty() && isClosed(s))
                return false;

            if (isOpen(s)) {
                stack.push(s);
            } else {
                if (!matches(stack.peek(), s)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    static boolean matches(String open, String close) {
        for (String[] pair : BRACKETS) {
            if (pair[0].equals(open) && pair[1].equals(close)) {
                return true;
            }
        }
        return false;
    }

    static boolean isClosed(String s) {

        for (String[] pair : BRACKETS) {
            if (pair[1].equals(s)) {
                return true;
            }
        }
        return false;
    }

    static boolean isOpen(String s) {

        for (String[] pair : BRACKETS) {
            if (pair[0].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression) ? "YES" : "NO"));
        }
    }
}
