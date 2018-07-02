package datastructure.linkedlist;

import datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;

import java.io.IOException;
import java.util.Scanner;

import static datastructure.linkedlist.LinkedListUtil.printSinglyLinkedList;

public class DeleteNodeFromLL {
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (head == null)
            return head;

        if (position == 0)
            return head.next;

        SinglyLinkedListNode res = head;
        SinglyLinkedListNode prev = null;
        while (position-- > 0 && head != null) {
            prev = head;
            head = head.next;
        }

        if (head != null) {
            prev.next = head.next;
        }

        return res;
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

        int position = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        SinglyLinkedListNode llist1 = deleteNode(llist.head, position);

        printSinglyLinkedList(llist1, " ");

        scanner.close();
    }
}
