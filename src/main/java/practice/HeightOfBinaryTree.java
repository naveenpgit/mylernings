package practice;

public class HeightOfBinaryTree {

    public static void main(String[] args) {


        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();

        LinkedListUtil.BSTNode root = heightOfBinaryTree.fillAnfReturnRoot();

        System.out.println(heightOfBinaryTree.height(root));

    }

    int height(LinkedListUtil.BSTNode current) {

        if (current == null)
            return -1; // For height initialise to 0

        int l = height(current.left);
        int r = height(current.right);

        return l > r ? l + 1 : r + 1;
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
