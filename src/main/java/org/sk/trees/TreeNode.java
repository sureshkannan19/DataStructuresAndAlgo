package org.sk.trees;

public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	

	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

	public static void print(TreeNode root) {
		if (root != null) {
			if (root.left != null && root.right != null) {
				System.out.println("Current Root : " + root.val + "\t Left : " + root.left.val + "\t Right : " + root.right.val);
			}
			print(root.left);
			print(root.right);
		}
	}

}
