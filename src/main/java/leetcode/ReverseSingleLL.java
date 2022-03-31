package leetcode;

import practice.LinkedListUtil.ListNode;

import static practice.LinkedListUtil.ListNode.fromArray;

public class ReverseSingleLL {

	public ListNode reverse(ListNode listNode) {
		System.out.println(listNode);
		ListNode prev = null;

		ListNode curr = listNode;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		System.out.println(prev);
		return prev;
	}

	public static void main(String[] args) {
		ReverseSingleLL reverseSingleLL = new ReverseSingleLL();
		reverseSingleLL.reverse(fromArray(new int[] { 1, 2, 3, 4 }));
	}
}
