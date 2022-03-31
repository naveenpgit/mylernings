package leetcode;

import util.BinaryTreeUtil.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

public class BinaryTreeTopView {
	public List<Integer> topView(TreeNode root) {

		Map<Integer, Integer> res = new TreeMap<>();
		helper(root, res);
		System.out.println(res.values().stream().map(String::valueOf).collect(java.util.stream.Collectors.joining(" ")));
		return res.values().stream().collect(toList());
	}

	void helper(TreeNode root, Map<Integer, Integer> res) {
		if (root == null)
			return;

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(root, 0));

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			if (pair.node != null) {
				res.putIfAbsent(pair.verticalLevel, pair.node.data);
				queue.add(new Pair(pair.node.left, pair.verticalLevel - 1));
				queue.add(new Pair(pair.node.right, pair.verticalLevel + 1));
			}
		}
	}

	class Pair {
		public TreeNode node;

		public int verticalLevel;

		public Pair(TreeNode node, int verticalLevel) {
			this.node = node;
			this.verticalLevel = verticalLevel;
		}
	}

	public static void main(String[] args) {
		TreeNode _1 = new TreeNode(1);
		TreeNode _2 = new TreeNode(2);
		TreeNode _3 = new TreeNode(3);
		TreeNode _4 = new TreeNode(4);
		TreeNode _5 = new TreeNode(5);
		TreeNode _6 = new TreeNode(6);
		_1.right = _2;
		_2.right = _5;
		_5.right = _6;
		_5.left = _3;
		_3.right = _4;

		BinaryTreeTopView binaryTreeTopView = new BinaryTreeTopView();
		System.out.println(binaryTreeTopView.topView(_1));
	}
}
