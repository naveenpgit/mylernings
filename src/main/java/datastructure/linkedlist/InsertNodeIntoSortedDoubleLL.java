package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.DoublyLinkedListNode;
import java.util.Scanner;
import static datastructure.linkedlist.LinkedListUtil.printDoublyLinkedList;

public class InsertNodeIntoSortedDoubleLL {

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        DoublyLinkedListNode res = head;

        if (head == null)
            return res;

        while (head.next != null && head.data <= data) {
            head = head.next;
        }
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if (head.data <= data) {
            head.next = newNode;
            newNode.prev = head;
        } else {
            DoublyLinkedListNode prev = head.prev;

            if (prev == null) {
                res = newNode;
                newNode.next = head;
            } else {
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = head;
                head.prev = newNode;
            }
        }
        return res;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            LinkedListUtil.DoublyLinkedList llist = new LinkedListUtil.DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);
            printDoublyLinkedList(llist1, " ");
        }
        scanner.close();
    }
}
