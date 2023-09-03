package org.sk.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
//		preorderTraversal(root, result);
		iterativePreorderTraversal(root, result);
		return result;
	}

	public void preorderTraversal(TreeNode root, List<Integer> result) {
		if (root != null) {
			result.add(root.val);
			preorderTraversal(root.left, result);
			preorderTraversal(root.right, result);
		}
	}

	public void iterativePreorderTraversal(TreeNode root, List<Integer> result) {
		LinkedList<TreeNode> tree = new LinkedList<>();
		tree.push(root);
		while (!tree.isEmpty()) {
			TreeNode temp = tree.pop();
			if (temp != null) {
				result.add(temp.val);
				tree.push(temp.right);
				tree.push(temp.left);
			}
		}
	}

	public static void main(String[] args) {
		PreorderTraversal pre = new PreorderTraversal();
		TreeNode source = new TreeNode(1);
		source.addLeft(2).addLeftAndRight(3, 4);
		source.addRight(2).addLeftAndRight(4, 3);
		System.out.println(pre.preorderTraversal(source)); // [1, 2, 3, 4, 2, 4, 3]
	}
}