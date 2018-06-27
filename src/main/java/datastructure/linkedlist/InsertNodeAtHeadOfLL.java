package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.printSinglyLinkedList;

public class InsertNodeAtHeadOfLL {
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode head = new SinglyLinkedListNode(data);
        head.next = llist;
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

            SinglyLinkedListNode llist_head = insertNodeAtHead(llist.head, llistItem);

            llist.head = llist_head;
        }
        printSinglyLinkedList(llist.head, "\n");
        scanner.close();
    }
}
