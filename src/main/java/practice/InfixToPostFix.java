package practice;

import java.util.Stack;
import java.util.stream.Stream;

public class InfixToPostFix {

    final static String OPEN = "(";
    final static String CLOSE = ")";


    enum PRIORITY {
        POWER("^", 3), MULTIPLY("*", 2), DIVISION("/", 2), PLUS("+", 1), MINUS("-", 1);

        private String value;
        private int priority;

        PRIORITY(String value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public String getValue() {
            return value;
        }

        public int getPriority() {
            return priority;
        }

        public int getPriorityFromValue(String value) {
            for (PRIORITY priority : values()) {
                if (priority.getValue().equals(value)) {
                    return priority.getPriority();
                }
            }

            return -1;
        }

        public boolean isOperator(String character) {
            return OPEN.equals(character) || CLOSE.equals(character) || getPriorityFromValue(character) != -1;
        }

    }


    public static void main(String[] args) {
        System.out.println(inFixToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
        System.out.println(inFixToPostFix("A*(B+C)/D"));
    }

    static String inFixToPostFix(final String in) {
        Stack<String> stack = new Stack<>();
        StringBuffer result = new StringBuffer("");

        Stream.of(in.split("")).forEach(current -> {
            if (!PRIORITY.POWER.isOperator(current)) {
                result.append(current);
            } else {
                switch (current) {
                    case OPEN: {
                        stack.push(current);
                        break;
                    }
                    case CLOSE: {
                        String topOfStack = stack.pop();
                        while (!OPEN.equals(topOfStack)) {
                            result.append(topOfStack);
                            topOfStack = stack.pop();
                        }
                        break;
                    }
                    default: {
                        if (stack.empty()) {
                            stack.push(current);
                        } else {
                            String topOfStack = stack.peek();
                            if (topOfStack != null) {
                                if (OPEN.equals(topOfStack) || PRIORITY.POWER.getPriorityFromValue(topOfStack) < PRIORITY.POWER.getPriorityFromValue(current)) {
                                    stack.push(current);
                                } else {
                                    while (topOfStack != OPEN && (PRIORITY.POWER.getPriorityFromValue(topOfStack) >= PRIORITY.POWER.getPriorityFromValue(current))) {
                                        result.append(stack.pop());
                                        topOfStack = stack.isEmpty() ? null : stack.peek();
                                    }
                                    stack.push(current);
                                }
                            }
                        }

                    }
                }
            }
        });

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
