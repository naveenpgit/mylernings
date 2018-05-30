package practice;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    static Stack<String> S_STACK = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        S_STACK.push("");
        int t = scanner.nextInt();

        while (t > 0) {

            int operation = scanner.nextInt();
            String operand = null;
            if (operation != 4) {
                operand = scanner.next();
            }
            operate(operation, operand);
            t--;
        }
    }

    private static void operate(int operation, String operand) {
        switch (operation) {
            case 1:
                S_STACK.push(S_STACK.peek() + operand);
                break;
            case 2:
                String temp = S_STACK.peek();
                temp = temp.substring(0, temp.length() - Integer.parseInt(operand));
                S_STACK.push(temp);
                break;
            case 3:
                System.out.println(S_STACK.peek().charAt(Integer.parseInt(operand) - 1));
                break;
            case 4:
                if (!S_STACK.isEmpty()) {
                    S_STACK.pop();
                }
                break;
        }
    }
}
