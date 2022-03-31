package util;

import lombok.Data;

public class BinaryTreeUtil {
	@Data
	public static class TreeNode {
		public int data;

		public TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
		}

		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}
}
