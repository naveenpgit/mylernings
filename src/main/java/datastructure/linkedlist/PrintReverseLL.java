package datastructure.linkedlist;

import java.util.*;
import java.util.stream.Collectors;

import datastructure.linkedlist.LinkedListUtil.SinglyLinkedList;
import datastructure.linkedlist.LinkedListUtil.SinglyLinkedListNode;

public class PrintReverseLL {
    static void reversePrint_(SinglyLinkedListNode head) {

        Deque<Integer> data = new ArrayDeque<>();
        while (head != null) {
            data.push(head.data);
            head = head.next;
        }
        data.iterator().forEachRemaining(System.out::println);
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head == null)
            return;
        reversePrint(head.next);
        System.out.println(head.data);
    }

    private static final Scanner scanner = new Scanner(System.in);

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

            reversePrint(llist.head);
        }

        scanner.close();
    }
}
