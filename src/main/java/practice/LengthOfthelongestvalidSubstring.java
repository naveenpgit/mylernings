package practice;

import java.util.Stack;

public class LengthOfthelongestvalidSubstring {
    public static void main(String[] args) {
        System.out.println(findLongest("((()") == 2);
        System.out.println(findLongest(")()())") == 4);
        System.out.println(findLongest("()(()))))") == 6);

        System.out.println(findLongest("(()(") == 2);
        System.out.println(findLongest("()()((") == 4);
        System.out.println(findLongest("((()()())))") == 10);
        System.out.println(findLongest("()(())(") == 6);
        System.out.println(findLongest("))))))()()))(())))())((()()()())(((()))())") == 20);
        System.out.println(findLongest("()()()()())(((((()))(()(((())())())(()(()(()") == 14);
        System.out.println(findLongest(")())))(()())()()(((()())()))(())))))(") == 26);


    }

    static int findLongest(String str) {
        int n = str.length();

        Stack<Character> stack = new Stack<>();

        int result = 0, max = 0;

        for (int i = n - 1; i > -1; i--) {
            // If opening bracket, push index of it
            if (str.charAt(i) == ')')
                stack.push(str.charAt(i));

            else // If closing bracket, i.e.,str[i] = ')'
            {
                if (i != n) {
                    if (stack.empty()) {
                        max = Math.max(result, max);
                        result = 0;
                    } else {
                        stack.pop();
                        result++;
                    }
                }
            }
        }

        return Math.max(result, max) * 2;
    }
}
