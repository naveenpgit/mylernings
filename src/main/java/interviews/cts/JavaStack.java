package interviews.cts;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {

    public static void main(String[] args) {
        Parser parser = new Parser();

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            System.out.println(parser.isBalanced(in.next()));
        }

        in.close();
    }
}

class Parser {
    final static String[][] BRACKETS = {{"(", ")"}, {"{", "}"}, {"[", "]"}};

    public boolean isBalanced(String next) {

        Stack<String> stack = new Stack<>();
        if (next.length() == 0)
            return true;

        String[] chars = next.split("");

        for (String s : chars) {

            if (isOpen(s))
                stack.push(s);
            else if (isClosed(s) && stack.empty())
                return false;
            else {
                String open = stack.pop();
                boolean res = matches(open, s);
                if(!res)
                    return false;
            }
        }
        return true && stack.isEmpty();
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

}
