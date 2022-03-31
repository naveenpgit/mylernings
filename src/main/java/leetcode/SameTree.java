package leetcode;

import util.BinaryTreeUtil.TreeNode;

//https://leetcode.com/problems/same-tree/
public class SameTree {
	public static void main(String[] args) {
		TreeNode p_1 = new TreeNode(1);
		TreeNode p_2 = new TreeNode(2);
		TreeNode p_3 = new TreeNode(3);

		TreeNode q_1 = new TreeNode(1);
		TreeNode q_2 = new TreeNode(2);
		TreeNode q_3 = new TreeNode(3);

		p_1.left = p_2;
		p_1.right = p_3;

		q_1.left = q_2;
		q_1.right = q_3;
		System.out.println(isSameTree(p_1, q_1));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;

		return p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
