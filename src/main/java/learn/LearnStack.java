package learn;

import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {
        Stack<Integer> linkedList = new Stack<>();
        linkedList.push(1);
        linkedList.push(2);
        linkedList.push(3);
        linkedList.push(4);
        linkedList.push(5);

        System.out.println(linkedList);
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
    }
}
