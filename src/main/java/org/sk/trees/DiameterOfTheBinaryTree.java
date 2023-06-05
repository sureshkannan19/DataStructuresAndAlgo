package org.sk.trees;

public class DiameterOfTheBinaryTree {

	public int diameterOfBinaryTree(TreeNode root) {
		int diameter[] = new int[1];
		findDiameter(root, diameter);
		return diameter[0];
	}

	private int findDiameter(TreeNode root, int[] diameter) {
		if (root == null) {
			return 0;
		}
		int left = findDiameter(root.left, diameter);
		int right = findDiameter(root.right, diameter);
		diameter[0] = Math.max(diameter[0], left + right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		DiameterOfTheBinaryTree dbt = new DiameterOfTheBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7));
		System.out.println(dbt.diameterOfBinaryTree(root));
	}
}
