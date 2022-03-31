package practice;

import lombok.Data;

public class LinkedListUtil {

	@Data
	public static class ListNode {
		public Integer val;

		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			if (next != null) {
				return val + "->" + next.toString();
			} else {
				return String.valueOf(val);
			}
		}

		public ListNode insertHead(ListNode node) {
			node.next = this;
			return node;
		}

		public static ListNode fromArray(int[] input) {
			ListNode head = null;
			ListNode prev = null;
			for (int i = 0; i < input.length; i++) {
				ListNode temp = new ListNode(input[i]);
				if (head == null) {
					head = temp;
					prev = head;
				} else {
					prev.next = new ListNode(input[i]);
					prev = prev.next;
				}
			}
			return head;
		}
	}

	@Data
	public static class SingleLLNode {
		public int data;

		public SingleLLNode next;

		public SingleLLNode(int data, SingleLLNode next) {
			this.data = data;
			this.next = next;
		}
	}

	@Data
	public static class BSTNode {
		public int data;

		public BSTNode left;

		public BSTNode right;

		public BSTNode(int data, BSTNode left, BSTNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
