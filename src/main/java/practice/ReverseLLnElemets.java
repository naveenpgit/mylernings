package practice;

import practice.LinkedListUtil.SingleLLNode;

public class ReverseLLnElemets {
    public static void main(String[] args) {

        SingleLLNode head = prepareAndReturnHead();
        SingleLLNode revreseHead = reversenIterms(head, head.next.next);

        while (revreseHead != null) {
            System.out.println(revreseHead.data + " => ");
            revreseHead = revreseHead.next;
        }
    }

    private static SingleLLNode reversenIterms(SingleLLNode head, SingleLLNode end) {

        if (head == null)
            return head;

        SingleLLNode p = end;
        SingleLLNode q = head;
        SingleLLNode r = q.next;

        while (q != end) {
            q.next = p;
            p = q;
            q = r;
            if (r != null)
                r = r.next;
        }

        return p;
    }

    static SingleLLNode prepareAndReturnHead() {
        SingleLLNode _1 = new SingleLLNode(1, null);
        SingleLLNode _8 = new SingleLLNode(8, null);
        SingleLLNode _3 = new SingleLLNode(3, null);
        SingleLLNode _4 = new SingleLLNode(4, null);

        _1.next = _8;
        _8.next = _3;
        _3.next = _4;

        return _1;
    }
}
