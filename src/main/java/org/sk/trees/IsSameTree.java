package org.sk.trees;

public class IsSameTree {

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
		IsSameTree ist = new IsSameTree();

		TreeNode source = new TreeNode(4);
		source.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		source.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
		System.out.println(ist.isSameTree(source, source));

		TreeNode target = new TreeNode(1, null, new TreeNode(2));
		source = new TreeNode(1, new TreeNode(2), null);
		System.out.println(ist.isSameTree(source, target));
	}
}
