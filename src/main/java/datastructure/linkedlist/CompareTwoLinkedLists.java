package datastructure.linkedlist;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;
import static datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;

public class CompareTwoLinkedLists {


    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        while (head1!=null && head2 !=null){
            if(head1.data != head2.data)
                return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 ==null && head2 == null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist1 = new SinglyLinkedList();

            int llist1Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist1Count; i++) {
                int llist1Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist1.insertNode(llist1Item);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();

            int llist2Count = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llist2Count; i++) {
                int llist2Item = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist2.insertNode(llist2Item);
            }

            boolean result = compareLists(llist1.head, llist2.head);

            System.out.println(result ? 1 : 0);
        }


        scanner.close();
    }
}
