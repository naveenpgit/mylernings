package interviews.ncr;

import practice.LinkedListUtil;

public class RemoveEven {

    public static void main(String[] args) {
        LinkedListUtil.SingleLLNode _1 = new LinkedListUtil.SingleLLNode(1, null);
        LinkedListUtil.SingleLLNode _2 = new LinkedListUtil.SingleLLNode(2, null);
        LinkedListUtil.SingleLLNode _3 = new LinkedListUtil.SingleLLNode(3, null);
        LinkedListUtil.SingleLLNode _4 = new LinkedListUtil.SingleLLNode(4, null);
        LinkedListUtil.SingleLLNode _6 = new LinkedListUtil.SingleLLNode(6, null);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _6;

        LinkedListUtil.SingleLLNode head = removeEve(_2);

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    static LinkedListUtil.SingleLLNode removeEve(LinkedListUtil.SingleLLNode head) {

        LinkedListUtil.SingleLLNode start = null;

        LinkedListUtil.SingleLLNode prev = null;
        while (head != null) {
            if (head.data % 2 == 0) {
                if (prev != null)
                    prev.next = head.next;
            } else {
                prev = head;
                if (start == null)
                    start = prev;
            }
            head = head.next;
        }

        return start;
    }
}
