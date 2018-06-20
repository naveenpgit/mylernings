package datastructure.linkedlist;

import java.util.Scanner;
import static datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;
import static datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import static datastructure.linkedlist.LinkedListUtil.printSinglyLinkedList;

public class ReverseALinkedList {

    private static final Scanner scanner = new Scanner(System.in);

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = current.next;
        while (current != null) {

            current.next = prev;
            prev = current;
            current = next;

            if (next != null)
                next = next.next;
        }

        return prev;
    }

    public static void main(String[] args) {

        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = reverse(llist.head);

            printSinglyLinkedList(llist1, " ");
        }
        scanner.close();
    }
}
