package org.sk.trees;

public class FindDepthofBinaryTreeViaRecursiveDFS {

	public int maxDepth(TreeNode root) {
		return findDepth(root, 0);
	}

	private int findDepth(TreeNode root, int depth) {
		/**	
		 * 				 4
		 * 				 |
		 * 			   /   \
		 * 			  2     7
		 * 		     / \   / \
		 * 		    1   3 6   9
		 */
		if (root != null) {
			int left = findDepth(root.left, depth);
//			System.out.println("Left val : " + left);
			int right = findDepth(root.right, depth);
//			System.out.println("Right val : " + right);
			depth = 1 + Math.max(left, right);
		}
		return depth;
	}

	public static void main(String[] args) {
		FindDepthofBinaryTreeViaRecursiveDFS ibt = new FindDepthofBinaryTreeViaRecursiveDFS();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
		System.out.println(ibt.maxDepth(root));
	}
}
