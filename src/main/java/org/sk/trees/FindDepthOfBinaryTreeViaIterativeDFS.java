package org.sk.trees;

import java.util.LinkedList;

public class FindDepthOfBinaryTreeViaIterativeDFS {

	public int maxDepth(TreeNode root) {
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

	class Pair {

		int depth;
		TreeNode root;

		public Pair(int depth, TreeNode root) {
			this.depth = depth;
			this.root = root;
		}

	}
	
	public static void main(String[] args) {
		FindDepthOfBinaryTreeViaIterativeDFS ibt = new FindDepthOfBinaryTreeViaIterativeDFS();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7));
		System.out.println(ibt.maxDepth(root));
	}
}
