//https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
package practice;

import java.util.Scanner;
import java.util.Stack;

public class TaleofTwoStacks {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    private static class MyQueue<T> {

        private Stack<T> enqueue = new Stack<>();
        private Stack<T> dequeue = new Stack<>();

        public void enqueue(T i) {

            enqueue.push(i);
        }

        public void dequeue() {
            if (dequeue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.push(enqueue.pop());
                }
            }

            dequeue.pop();
        }

        public T peek() {
            if (dequeue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.push(enqueue.pop());
                }
            }
            return dequeue.peek();
        }
    }
}
