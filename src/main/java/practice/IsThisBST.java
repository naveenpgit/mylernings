package practice;

import practice.LinkedListUtil.BSTNode;

public class IsThisBST {

    static int top = Integer.MIN_VALUE;

    public static void main(String[] args) {

        System.out.println(checkBST(fillAnfReturnRoot()));
    }

    static boolean checkBST(BSTNode root) {
        if (root == null)
            return true;
        return checkBST(root.left) && print(root.data) && checkBST(root.right);
    }

    private static boolean print(int data) {
        if (top < data) {
            top = data;
            return true;
        } else
            return false;
    }

    private static BSTNode fillAnfReturnRoot() {
        BSTNode _1 = new BSTNode(1, null, null);
        BSTNode _2 = new BSTNode(2, null, null);
        BSTNode _5 = new BSTNode(5, null, null);
        BSTNode _3 = new BSTNode(3, null, null);
        BSTNode _4 = new BSTNode(4, null, null);
        BSTNode _6 = new BSTNode(6, null, null);
        BSTNode _7 = new BSTNode(7, null, null);

        _4.left = _2;
        _4.right = _6;
        _2.left = _1;
        _2.right = _3;
        _6.left = _5;
        _6.right = _7;

        return _4;

    }
}
