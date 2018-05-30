package practice;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        LinkedListUtil.BSTNode bstNode = levelOrderTraversal.fillAnfReturnRoot();

        Queue<LinkedListUtil.BSTNode> queue = new LinkedList<>();
        queue.add(bstNode);
        while (!queue.isEmpty()) {
            LinkedListUtil.BSTNode node = queue.remove();
            print(node.data);

            if (node.left != null)
                queue.add(node.left);

            if (node.right != null)
                queue.add(node.right);
        }
    }

    private static void print(int data) {
        System.out.print(data + " ");
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
     *      levelOrder = 1 2 5 3 6 4
     */
    private LinkedListUtil.BSTNode fillAnfReturnRoot() {
        LinkedListUtil.BSTNode _1 = new LinkedListUtil.BSTNode(1, null, null);
        LinkedListUtil.BSTNode _2 = new LinkedListUtil.BSTNode(2, null, null);
        LinkedListUtil.BSTNode _5 = new LinkedListUtil.BSTNode(5, null, null);
        LinkedListUtil.BSTNode _3 = new LinkedListUtil.BSTNode(3, null, null);
        LinkedListUtil.BSTNode _4 = new LinkedListUtil.BSTNode(4, null, null);
        LinkedListUtil.BSTNode _6 = new LinkedListUtil.BSTNode(6, null, null);

        _1.right = _2;
        _2.right = _5;
        _5.right = _6;
        _5.left = _3;
        _3.right = _4;

        return _1;

    }
}
