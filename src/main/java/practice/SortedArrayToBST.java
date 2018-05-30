package practice;

import practice.LinkedListUtil.BSTNode;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/array-to-bst/0
public class SortedArrayToBST {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int N = scanner.nextInt();
            int[] sortedArray = new int[N];
            for (int j = 0; j < N; j++) {
                sortedArray[j] = scanner.nextInt();
            }

            BSTNode root = createBST(sortedArray, 0, sortedArray.length - 1);

            printPreOrder(root);
        }
    }

    static void printPreOrder(BSTNode root) {

        if (root == null) return;

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    static BSTNode createBST(int[] array, int start, int end) {

        if (start > end) return null;
        int mid = (start + end) / 2;

        BSTNode root = new BSTNode(array[mid], null, null);
        root.left = (createBST(array, start, mid - 1));
        root.right = (createBST(array, mid + 1, end));

        return root;
    }

}
