package practice;

import practice.LinkedListUtil.SingleLLNode;

public class RemoveNthNodeFromLL {

    final static int N = 2;

    public static void main(String[] args) {

        RemoveNthNodeFromLL removeNthNodeFromLL = new RemoveNthNodeFromLL();
        SingleLLNode nThNode = removeNthNodeFromLL.findNth(createAndReturnhead(), N);

        System.out.println(N + "th node from end :::: " + nThNode.data);

        System.out.println("After removing " + N + "th node from end :::: ");
        SingleLLNode newHead = removeNthNodeFromLL.removeNth(createAndReturnhead(), N);
        while (newHead != null) {
            System.out.println(newHead.data + " -> ");
            newHead = newHead.next;
        }
    }

    private SingleLLNode findNth(SingleLLNode head, int n) {
        int j = 0;
        SingleLLNode p = head, q = head;

        while (j++ < n) {
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    private SingleLLNode removeNth(SingleLLNode head, int n) {
        int j = 0;
        SingleLLNode p = head, q = head;

        while (j++ < n) {
            q = q.next;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return head;
    }

    private static SingleLLNode createAndReturnhead() {
        SingleLLNode _1 = new SingleLLNode(1, null);
        SingleLLNode _2 = new SingleLLNode(2, null);
        SingleLLNode _3 = new SingleLLNode(3, null);
        SingleLLNode _4 = new SingleLLNode(4, null);
        SingleLLNode _5 = new SingleLLNode(5, null);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        return _1;
    }
}
