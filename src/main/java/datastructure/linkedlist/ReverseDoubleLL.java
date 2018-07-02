package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.DoublyLinkedListNode;
import datastructure.linkedlist.LinkedListUtil.DoublyLinkedList;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.printDoublyLinkedList;

public class ReverseDoubleLL {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head.next != null)
            reverse(head.next);

        DoublyLinkedListNode temp = head.next;
        head.next= head.prev;
        head.prev = temp;
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            LinkedListUtil.DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ");
        }
        scanner.close();
    }
}
