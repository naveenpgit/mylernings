package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.printSinglyLinkedList;

public class MergeTwoSortedLinkedLists {

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode prev = null;
        while (head1 != null && head2 != null) {

            SinglyLinkedListNode current = null;
            if (head1.data <= head2.data) {
                current = head1;
                head1 = head1.next;
            } else {
                current = head2;
                head2 = head2.next;
            }

            if (newHead == null) {
                newHead = current;
            }
            if (prev != null) {
                prev.next = current;
            }
            prev = current;
        }

        if (head1 == null) {
            prev.next = head2;
        }
        if (head2 == null) {
            prev.next = head1;
        }
        return newHead;
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

            SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

            printSinglyLinkedList(llist3, " ");
        }
        scanner.close();
    }

}
