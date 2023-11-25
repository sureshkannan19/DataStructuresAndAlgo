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
		TreeNode source = new TreeNode(4).leftAndRight(2, 7);
		source.left.leftAndRight(1, 3);
		source.right.leftAndRight(6, 9);
		TreeNode.print(ibt.invertTree(source));
	}
}
