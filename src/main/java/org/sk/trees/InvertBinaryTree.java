package org.sk.trees;

public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		
		/**	
		 * 				 4
		 * 				 |
		 * 			   /   \
		 * 			  2     7
		 * 		     / \   / \
		 * 		    1   3 6   9
		 */

		
		if (root != null) {
			TreeNode temp = root.right;
			root.right = root.left;
			root.left = temp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}

	public static void main(String[] args) {
		InvertBinaryTree ibt = new InvertBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
		TreeNode.print(ibt.invertTree(root));
	}
}
