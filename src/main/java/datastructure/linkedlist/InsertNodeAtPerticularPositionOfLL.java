package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.printSinglyLinkedList;

public class InsertNodeAtPerticularPositionOfLL {
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode resHead = head;
        if (head == null)
            return head;
        else {
            while (--position > 0) {
                head = head.next;
            }

            SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
            temp.next = head.next;
            head.next = temp;
        }
        return resHead;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

        printSinglyLinkedList(llist_head, " ");
        scanner.close();
    }
}
