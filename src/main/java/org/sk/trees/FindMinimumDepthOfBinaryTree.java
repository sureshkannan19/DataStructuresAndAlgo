package org.sk.trees;

import java.util.LinkedList;

public class FindMinimumDepthOfBinaryTree {
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
//		return minDepthIteration(root);
		return minDepthRecursive(root, 1, Integer.MAX_VALUE);
	}

	public int minDepthIteration(TreeNode root) {
		LinkedList<Pair> stack = new LinkedList<>();
		stack.push(new Pair(1, root));

		// BFS
		int depth = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			Pair temp = stack.pop();
			if (temp != null && temp.root != null && (temp.root.right == null && temp.root.left == null)) {
				depth = Math.min(depth, temp.depth);
			}
			if (temp != null && (root = temp.root) != null) {
				stack.push(new Pair(temp.depth + 1, root.right));
				stack.push(new Pair(temp.depth + 1, root.left));
			}
		}
		return depth;
	}

	
	public int minDepthRecursive(TreeNode root, int temp, int depth) {
		if(root == null) {
			return depth;
		}
		if (root != null && root.left == null && root.right == null) {
			depth = Math.min(temp, depth);
			return depth;
		}
		depth = minDepthRecursive(root.left, temp + 1, depth);
		depth = minDepthRecursive(root.right, temp + 1, depth);
		return depth;
	}

	public static void main(String[] args) {
		FindMinimumDepthOfBinaryTree ibt = new FindMinimumDepthOfBinaryTree();
		TreeNode root = new TreeNode(3);
		root.addLeftAndRight(9, 20).getRight().addLeftAndRight(15, 7);
		System.out.println(ibt.minDepth(root));
		root = new TreeNode(3);
		System.out.println(ibt.minDepth(root));
		root = new TreeNode(15);
		root.addLeftAndRight(9, 20).getLeft().addLeftAndRight(8, 10);
		root.getRight().addLeftAndRight(19, 21);
		System.out.println(ibt.minDepth(root));
		root = new TreeNode(2);
		root.addRight(3).addRight(4).addRight(5).addRight(6);
		System.out.println(ibt.minDepth(root));
	}

}