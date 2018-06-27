package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.printSinglyLinkedList;

public class InsertNodeAtEndOfLL {
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        if (head == null)
            head = new SinglyLinkedListNode(data);
        else {
            SinglyLinkedListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new SinglyLinkedListNode(data);
        }
        return head;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

            llist.head = llist_head;
        }
        printSinglyLinkedList(llist.head, "\n");

        scanner.close();
    }
}
