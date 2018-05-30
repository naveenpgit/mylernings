package practice;

import lombok.Data;


public class TopViewofBinaryTree {

    @Data
    class TreeNode {
        int key;
        TreeNode left, right;

        public TreeNode(int key, TreeNode left, TreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TopViewofBinaryTree topViewofBinaryTree = new TopViewofBinaryTree();
        topViewofBinaryTree.printTopView(topViewofBinaryTree.fillAnfReturnRoot_());
    }

    public void printTopView(TreeNode root) {
        System.out.print(root.key + " ");
        printD(root.left, root.right);
    }

    public void printD(TreeNode left, TreeNode right) {
        TreeNode newL = null;
        TreeNode newR = null;

        if (left == null && right == null) {
            return;
        }

        if (left != null) {
            System.out.print(left.key + " ");
            newL = left.left;
        }

        if (right != null) {
            System.out.print(right.key + " ");
            newR = right.right;
        }

        printD(newL, newR);
    }

    private TreeNode fillAnfReturnRoot() {
        TreeNode _1 = new TreeNode(1, null, null);
        TreeNode _2 = new TreeNode(2, null, null);
        TreeNode _3 = new TreeNode(3, null, null);
        _1.left = _2;
        _1.right = _3;

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
