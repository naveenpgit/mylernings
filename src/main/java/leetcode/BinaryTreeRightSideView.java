package leetcode;

import util.BinaryTreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();

		List<Integer> res = new ArrayList<>();

		//approach_1(root, queue, res);
		approach_2(root, new HashSet<>(), res, 0);
		return res;
	}

	private void approach_1(TreeNode node, Queue<TreeNode> queue, List<Integer> res) {
		if (node != null) {
			queue.add(node);
			queue.add(null);
		}
		TreeNode prev = null;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if (temp == null && !queue.isEmpty()) {
				queue.add(null);
				if (prev != null)
					res.add(prev.data);
			} else if (temp != null) {
				prev = temp;
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		if (prev != null)
			res.add(prev.data);
	}

	public static void main(String[] args) {
		TreeNode _1 = new TreeNode(1);
		TreeNode _2 = new TreeNode(2);
		TreeNode _3 = new TreeNode(3);
		TreeNode _4 = new TreeNode(4);
		TreeNode _5 = new TreeNode(5);
		_1.left = _2;
		_1.right = _3;
		_2.right = _5;
		_3.right = _4;

		BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
		System.out.println(binaryTreeRightSideView.rightSideView(_1));
	}

	public void approach_2(TreeNode root, Set<Integer> levels, List<Integer> res, int level) {
		if (root == null) {
			return;
		}

		if (!levels.contains(level)) {
			levels.add(level);
			res.add(root.data);
		}
		if (root.left == null && root.right == null) {
			return;
		}
		level += 1;
		approach_2(root.right, levels, res, level);
		approach_2(root.left, levels, res, level);
	}
}
