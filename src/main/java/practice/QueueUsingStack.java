//https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
package practice;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MyQueue<Integer> myQueue = new MyQueue();

        int operations = scanner.nextInt();

        while (operations > 0) {

            switch (scanner.nextInt()) {
                case 1:
                    myQueue.enqueue(scanner.nextInt());
                    break;
                case 2:
                    myQueue.dequeue();
                    break;
                case 3:
                    System.out.println(myQueue.peek());
                    break;
            }

            operations--;
        }

    }
}

class MyQueue<T> {

    private Stack<T> enqueueStack = new Stack<>();
    private Stack<T> dequeueStack = new Stack<>();

    public void enqueue(T t) {
        enqueueStack.push(t);
    }

    public void dequeue() {
        if (dequeueStack.isEmpty()) {
            copy();
        }
        dequeueStack.pop();
    }

    public T peek() {
        if (dequeueStack.isEmpty()) {
            copy();
        }
        return dequeueStack.peek();
    }

    private void copy() {
        while (!enqueueStack.isEmpty()) {
            dequeueStack.push(enqueueStack.pop());
        }
    }
}
