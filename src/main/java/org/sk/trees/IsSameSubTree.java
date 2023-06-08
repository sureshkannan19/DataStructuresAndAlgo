package org.sk.trees;

public class IsSameSubTree {

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (subRoot == null) {
			return true;
		}
		if (root == null) { // && subRoot != null
			return false;
		}
		if (isSameTree(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if ((p != null && q == null) || (p == null && q != null)) {
			return false;
		}
		if (p != null && q != null) {
			if (p.val != q.val) {
				return false;
			}
			if (!isSameTree(p.left, q.left)) {
				return false;
			}
			if (!isSameTree(p.right, q.right)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsSameSubTree ist = new IsSameSubTree();

		TreeNode source = new TreeNode(4);
		source.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		source.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

		System.out.println(ist.isSubtree(source, source.left));

		TreeNode subTree = new TreeNode(4, new TreeNode(1), new TreeNode(2));
		source = new TreeNode(3, subTree, new TreeNode(5));
		System.out.println(ist.isSubtree(source, subTree));

		source = new TreeNode(1);
		System.out.println(ist.isSubtree(source, source));

		source = new TreeNode(1, new TreeNode(1), null);
		subTree = new TreeNode(1);
		System.out.println(ist.isSubtree(source, subTree));
	}
}
