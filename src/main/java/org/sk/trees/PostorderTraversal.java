package org.sk.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
//		postorderTraversal(root, result);
		iterativePostorderTraversal(root, result);
		return result;
	}

	public void postorderTraversal(TreeNode root, List<Integer> result) {
		if (root != null) {
			postorderTraversal(root.left, result);
			postorderTraversal(root.right, result);
			result.add(root.val);
		}
	}

	public void iterativePostorderTraversal(TreeNode root, List<Integer> result) {
		TreeNode pre = null;
		LinkedList<TreeNode> tree = new LinkedList<>();
		while (root != null || !tree.isEmpty()) {
			// Go deep left --> Iterate till left node becomes null
			if (root != null) {
				tree.push(root);
				root = root.left;
			} else {
				root = tree.peek(); // not popping because current root node might have child nodes that are yet to
									// be processed
				/**
				 * Print nodes: Left --> Right --> Root Validate the root node does not have any
				 * right node, if root node has right node then send that right node to get its
				 * deep left node to above if block else add it to the output list and pop the
				 * root node from stack and store the last processed node as pre
				 **/
				if (root.right == null || root.right == pre) {
					result.add(root.val);
					tree.pop();
					pre = root;
					root = null;
				} else {
					root = root.right;
				}
			}
		}
	}

	public static void main(String[] args) {
		PostorderTraversal post = new PostorderTraversal();
		TreeNode source = new TreeNode(1);
		source.left(2).leftAndRight(3, 4).right.right(5);
		source.right(2).leftAndRight(4, 3);
		System.out.println(post.postorderTraversal(source)); // [3, 5, 4, 2, 4, 3, 2, 1]
	}
}