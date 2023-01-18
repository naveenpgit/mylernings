import util.BinaryTreeUtil.TreeNode

fun main(args: Array<String>) {
    val root = TreeNode(1)
    val l_2 = TreeNode(2)

    val l_2_l_3 = TreeNode(3)
    val l_2_r_4 = TreeNode(4)
    l_2.left = l_2_l_3
    l_2.right = l_2_r_4

    val r_2 = TreeNode(2)
    val r_2_l_4 = TreeNode(4)
    val r_2_r_3 = TreeNode(3)
    r_2.left = r_2_l_4
    r_2.right = r_2_r_3


    root.left = l_2
    root.right = r_2
    println(isSymmetric(root))

}

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null)
        return true

    return helper(root.left, root.right)
}

fun helper(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null)
        return true
    if (p == null || q == null)
        return false
    return p.data == q.data && helper(p.left, q.right) && helper(p.right, q.left)
}