package org.sk.trees;

import java.util.LinkedList;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		return isMirrorViaDFS(root.left, root.right);
//		return isMirrorViaIteration(root);
	}

	public boolean isMirrorViaDFS(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.val == root2.val) {
			return isMirrorViaDFS(root1.right, root2.left) && isMirrorViaDFS(root2.right, root1.left);
		}
		return false;
	}

	public boolean isMirrorViaIteration(TreeNode root) {
		TreeNode root1 = root.left;
		TreeNode root2 = root.right;

		LinkedList<TreeNode> tree = new LinkedList<>();
		tree.push(root1);
		tree.push(root2);

		while (!tree.isEmpty()) {
			root1 = tree.pop();
			root2 = tree.pop();
			if (root1 == null && root2 == null) {
				continue;
			}
			if (root1 == null || root2 == null) {
				return false;
			}
			if (root1.val == root2.val) {
				tree.push(root1.right);
				tree.push(root2.left);
				tree.push(root1.left);
				tree.push(root2.right);
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SymmetricTree ps = new SymmetricTree();
		TreeNode source = new TreeNode(1);
		source.addLeft(2).addLeftAndRight(3, 4);
		source.addRight(2).addLeftAndRight(4, 3);
		System.out.println(ps.isSymmetric(source));

		source = new TreeNode(1, new TreeNode(2), new TreeNode(3));
		System.out.println(ps.isSymmetric(source));
	}
}
