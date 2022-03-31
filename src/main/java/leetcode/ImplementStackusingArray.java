package leetcode;

public class ImplementStackusingArray {
	static class MyStack {
		int top;

		int arr[] = new int[1000];

		MyStack() {
			top = -1;
		}

		//Function to push an integer into the stack.
		void push(int a) {
			if (top == arr.length) {
				return;
			}
			arr[++top] = a;
		}

		//Function to remove an item from top of the stack.
		int pop() {
			if (top < 0) {
				return -1;
			}
			// Your code here
			final int temp = arr[top--];
			return temp == 0 ? -1 : temp;
		}
	}

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		System.out.println(stack.pop());
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
	}
}
