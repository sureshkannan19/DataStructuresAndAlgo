package org.sk.trees;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return hasPathSumViaSub(root, targetSum);
//		return hasPathSumViaAdd(root, 0, targetSum);
	}

	public boolean hasPathSumViaSub(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return targetSum - root.val == 0;
		}
		return hasPathSumViaSub(root.left, targetSum - root.val) || hasPathSumViaSub(root.right, targetSum - root.val);
	}

	public boolean hasPathSumViaAdd(TreeNode root, int sum, int targetSum) {
		if (root == null) {
			return false;
		}
		sum += root.val;
		if (root.left == null && root.right == null) {
			return targetSum == sum;
		}
		return hasPathSumViaAdd(root.left, root.val, targetSum) || hasPathSumViaAdd(root.right, sum, targetSum);
	}

	public static void main(String[] args) {
		PathSum ps = new PathSum();
		TreeNode source = new TreeNode(5);
		source.left(4).left(11).leftAndRight(7, 2);
		source.right(8).leftAndRight(13, 4).right.left(1);
		System.out.print(ps.hasPathSum(source, 22));

	}
}