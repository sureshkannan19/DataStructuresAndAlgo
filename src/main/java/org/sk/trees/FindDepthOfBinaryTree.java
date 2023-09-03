package org.sk.trees;

import java.util.LinkedList;

public class FindDepthOfBinaryTree {

	public int maxDepthViaIteration(TreeNode root) {
		int depth = 0;
		
		LinkedList<Pair> tree = new LinkedList<>();
		tree.push(new Pair(1, root));

		while (!tree.isEmpty()) {
			Pair temp = tree.pop();
			if (temp.root != null) {
				depth = Math.max(depth , temp.depth);
				tree.push(new Pair(temp.depth + 1, temp.root.right));
				tree.push(new Pair(temp.depth + 1, temp.root.left));
			}
		}
		return depth;
	}
	
	private int maxDepthViaRecursive(TreeNode root, int depth) {
		/**	
		 * 				 4
		 * 				 |
		 * 			   /   \
		 * 			  2     7
		 * 		     / \   / \
		 * 		    1   3 6   9
		 */
		if (root != null) {
			int left = maxDepthViaRecursive(root.left, depth);
//			System.out.println("Left val : " + left);
			int right = maxDepthViaRecursive(root.right, depth);
//			System.out.println("Right val : " + right);
			depth = 1 + Math.max(left, right);
		}
		return depth;
	}

	public static void main(String[] args) {
		FindDepthOfBinaryTree ibt = new FindDepthOfBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7));
		System.out.println(ibt.maxDepthViaIteration(root));
		System.out.println(ibt.maxDepthViaRecursive(root, 0));
	}
}
