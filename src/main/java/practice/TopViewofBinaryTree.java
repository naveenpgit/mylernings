package practice;

import lombok.Data;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class TopViewofBinaryTree {

    @Data
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    @Data
    static class Rank implements Comparable {
        int row;
        int score;

        public Rank(int score) {
            this.score = score;
        }

        @Override
        public int compareTo(Object o) {
            Rank temp = (Rank) o;
            return temp.score - this.score;
        }

        @Override
        public boolean equals(Object o) {
            Rank temp = (Rank) o;
            return temp.score == this.score;
        }

        @Override
        public int hashCode() {
            return super.hashCode() * this.score;
        }
    }

    static Map<Rank, Integer> treeMap = new TreeMap<>();

    public static void topView(TreeNode root) {

        printD(root, 0);
        //System.out.println(treeMap.size());

        treeMap.entrySet().stream().forEach(entry -> System.out.print(entry.getValue() + " "));
        System.out.println("");
        System.out.println("1 2 4 14 23 37 108 111 115 116 83 84 85 ");
        System.out.println("------------");

        int start = 0;
        while (!treeMap.isEmpty()) {
            Integer remove = treeMap.remove(start * -1);
            if (remove != null)
                System.out.print(remove + " ");
            remove = treeMap.remove(start);
            if (remove != null)
                System.out.print(remove + " ");

            start++;
        }



    }

    static void printD(TreeNode node, int score) {
        if (node == null)
            return;
        if (score > 0)
            treeMap.put(new Rank(score), node.data);
        else
            treeMap.putIfAbsent(new Rank(score), node.data);
        printD(node.left, score - 1);
        printD(node.right, score + 1);
    }

    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        } else {
            TreeNode cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
    private TreeNode fillAnfReturnRoot() {
        TreeNode _1 = new TreeNode(1, null, null);
        TreeNode _2 = new TreeNode(2, null, null);
        TreeNode _3 = new TreeNode(3, null, null);
        TreeNode _4 = new TreeNode(4, null, null);
        TreeNode _5 = new TreeNode(5, null, null);
        TreeNode _6 = new TreeNode(6, null, null);
        TreeNode _7 = new TreeNode(7, null, null);

        _1.left = _2;
        _1.right = _3;

        _2.left = _4;
        _2.right = _5;

        _3.left = _6;
        _3.right = _7;

        return _1;
    }

    private TreeNode fillAnfReturnRoot_() {
        TreeNode _10 = new TreeNode(10, null, null);
        TreeNode _20 = new TreeNode(20, null, null);
        TreeNode _30 = new TreeNode(30, null, null);
        TreeNode _40 = new TreeNode(40, null, null);
        TreeNode _60 = new TreeNode(60, null, null);
        TreeNode _90 = new TreeNode(90, null, null);

        _10.left = _20;
        _10.right = _30;

        _20.left = _40;
        _20.right = _60;
        _30.left = _90;

        return _10;
    }
}
