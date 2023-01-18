import util.BinaryTreeUtil.TreeNode

fun main(args: Array<String>) {
    val p_1 = TreeNode(1)
    val p_2 = TreeNode(2)
    val p_3 = TreeNode(3)

    val q_1 = TreeNode(1)
    val q_2 = TreeNode(2)
    val q_3 = TreeNode(3)

    p_1.left = p_2
    p_1.right = p_3

    q_1.left = q_2
    q_1.right = q_3
    println(isSameTree(p_1, q_1))

}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }
    if (p == null || q == null) {
        return false
    }
    return p?.data == q?.data && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}