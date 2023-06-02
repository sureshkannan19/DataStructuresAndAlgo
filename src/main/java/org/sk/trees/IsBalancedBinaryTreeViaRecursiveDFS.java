package org.sk.trees;

public class IsBalancedBinaryTreeViaRecursiveDFS {

	public boolean isBalanced(TreeNode root) {
		return maxDepth(root, 0) != -1;
	}

	private int maxDepth(TreeNode root, int depth) {
		if (root != null && depth != -1) {
			int left = maxDepth(root.left, depth);
			if (left == -1) {
				return left;
			}
			int right = maxDepth(root.right, depth);
			if (right == -1) {
				return right;
			}
			if (Math.abs(left - right) > 1) {
				return -1;
			} else {
				return 1 + Math.max(left, right);
			}
		}
		return depth;
	}

	public static void main(String[] args) {
		IsBalancedBinaryTreeViaRecursiveDFS ibt = new IsBalancedBinaryTreeViaRecursiveDFS();
		// 1,2,2,3,null,null,3,4,null,null,4
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null);
		root.right = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4)));
		System.out.println(ibt.isBalanced(root));
	}
}
