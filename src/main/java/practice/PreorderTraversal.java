package practice;

import static practice.LinkedListUtil.BSTNode;

public class PreorderTraversal {


    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        BSTNode root = preorderTraversal.fillAnfReturnRoot();

        preorderTraversal.preOrder(root);
        System.out.println();
        preorderTraversal.preOrder_(root);
        System.out.println("\n-------------------");
        preorderTraversal.postOrder(root);
        System.out.println();
        preorderTraversal.postOrder_(root);
        System.out.println("\n-------------------");

        preorderTraversal.inOrder(root);
        System.out.println();
        preorderTraversal.inOrder_(root);
        System.out.println("\n-------------------");
    }

    void preOrder(BSTNode root) {
        print(root.data);
        if (root.left != null)
            preOrder(root.left);

        if (root.right == null)
            return;
        else
            preOrder(root.right);
    }

    void preOrder_(BSTNode root) {
        if (root == null)
            return;
        print(root.data);
        preOrder_(root.left);
        preOrder_(root.right);
    }

    void postOrder(BSTNode root) {
        if (root.left != null) {
            postOrder(root.left);

            if (root.right != null) {
                postOrder(root.right);
            }
            print(root.data);
        } else if (root.right != null) {
            postOrder(root.right);
            print(root.data);
        } else {
            print(root.data);
            return;
        }
    }

    void postOrder_(BSTNode root) {
        if (root == null)
            return;
        postOrder_(root.left);
        postOrder_(root.right);
        print(root.data);
    }

    private void print(int data) {
        System.out.print(data + " ");
    }

    void inOrder(BSTNode root) {
        if (root.left == null) {
            print(root.data);
        } else {
            inOrder(root.left);
            print(root.data);
        }
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    void inOrder_(BSTNode root) {
        if (root == null)
            return;
        inOrder_(root.left);
        print(root.data);
        inOrder_(root.right);
    }


    /*
     *                      1
     *                       \
     *                        2
     *                         \
     *                          5
     *                         / \
     *                        3   6
     *                         \
     *                          4
     *
     *      preOrder = 1 2 5 3 4 6
     *      PostOrder = 4 3 6 5 2 1
     *      inorder = 1 2 3 4 5 6
     */
    private BSTNode fillAnfReturnRoot() {
        BSTNode _1 = new BSTNode(1, null, null);
        BSTNode _2 = new BSTNode(2, null, null);
        BSTNode _5 = new BSTNode(5, null, null);
        BSTNode _3 = new BSTNode(3, null, null);
        BSTNode _4 = new BSTNode(4, null, null);
        BSTNode _6 = new BSTNode(6, null, null);

        _1.right = _2;
        _2.right = _5;
        _5.right = _6;
        _5.left = _3;
        _3.right = _4;

        return _1;

    }
}
