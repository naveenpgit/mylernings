package leetcode;

import practice.LinkedListUtil.ListNode;

import static practice.LinkedListUtil.ListNode.fromArray;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode resHead = _add(l1, l2);

		System.out.println(resHead.toString());

		return resHead;
	}

	ListNode _add(ListNode l1, ListNode l2) {
		int prev_rem = 0;
		ListNode res = null;

		ListNode resHead = null;
		while (l1 != null || l2 != null) {

			int l1_val = l1 != null ? l1.val : 0;
			int l2_val = l2 != null ? l2.val : 0;

			final int sum = l1_val + l2_val + prev_rem;
			prev_rem = sum / 10;

			if (res == null) {
				res = new ListNode(sum % 10);
				resHead = res;
			} else {
				res.next = new ListNode(sum % 10);
				res = res.next;
			}
			l1 = l1 != null ? l1.next : l1;
			l2 = l2 != null ? l2.next : l2;
		}
		if (prev_rem != 0) {
			res.next = new ListNode(prev_rem);
			res = res.next;
		}
		return resHead;
	}

	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		addTwoNumbers.addTwoNumbers(fromArray(new int[] { 9, 9, 9, 9, 9, 9, 9 }), fromArray(new int[] { 9, 9, 9, 9 }));
		addTwoNumbers.addTwoNumbers(fromArray(new int[] { 2, 4, 3 }), fromArray(new int[] { 5, 6, 4 }));
//		addTwoNumbers.addTwoNumbers(fromArray(new int[] { 0 }), fromArray(new int[] { 0 }));
		addTwoNumbers.addTwoNumbers(fromArray(new int[] { 2, 4, 9 }), fromArray(new int[] { 5, 6, 4, 9 }));
	}
}
