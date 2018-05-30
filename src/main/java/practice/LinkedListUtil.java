package practice;

import lombok.Data;

public class LinkedListUtil {

    @Data
    public static class SingleLLNode {
        public int data;
        public SingleLLNode next;

        public SingleLLNode(int data, SingleLLNode next) {
            this.data = data;
            this.next = next;
        }
    }


    @Data
    public static class BSTNode {
        public int data;
        public BSTNode left;
        public BSTNode right;

        public BSTNode(int data, BSTNode left, BSTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
