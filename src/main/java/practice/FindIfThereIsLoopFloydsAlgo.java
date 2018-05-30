package practice;

import static practice.LinkedListUtil.SingleLLNode;

public class FindIfThereIsLoopFloydsAlgo {


    public static void main(String[] args) {
        FindIfThereIsLoopFloydsAlgo findIfThereIsLoopFloydsAlgo = new FindIfThereIsLoopFloydsAlgo();
        System.out.println(findIfThereIsLoopFloydsAlgo.removeTheLoop(findIfThereIsLoopFloydsAlgo.prepareAndReturnHead()));
        System.out.println(findIfThereIsLoopFloydsAlgo.removeTheLoop(findIfThereIsLoopFloydsAlgo.prepareAndReturnHead_2()));

    }

    public SingleLLNode prepareAndReturnHead() {
        SingleLLNode _1 = new SingleLLNode(1, null);
        SingleLLNode _3 = new SingleLLNode(3, null);
        SingleLLNode _4 = new SingleLLNode(4, null);

        _1.next = _3;
        _3.next = _4;
        _4.next = _3;

        return _1;
    }


    public SingleLLNode prepareAndReturnHead_2() {
        SingleLLNode _1 = new SingleLLNode(1, null);
        SingleLLNode _8 = new SingleLLNode(8, null);
        SingleLLNode _3 = new SingleLLNode(3, null);
        SingleLLNode _4 = new SingleLLNode(4, null);

        _1.next = _8;
        _8.next = _3;
        _3.next = _4;

        return _1;
    }

    int removeTheLoop(SingleLLNode head) {

        SingleLLNode slow = head;
        SingleLLNode fast = head;

        while (slow != null && fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return 1;
            }
        }
        return 0;
    }
}
