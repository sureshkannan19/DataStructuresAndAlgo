package org.sk.trees;

public class InsertIntoBinaryTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root != null) {
            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.left = insertIntoBST(root.left, val);
            }
        } else {
            root = new TreeNode(val);
        }
        return root;
    }

    public TreeNode insertIntoBSTViaIter(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;
        while (true) {
            if (val > current.val) {
                if (null == current.right) {
                    current.right = new TreeNode(val);
                    break;
                }
                current = current.right;
            } else {
                if (null == current.left) {
                    current.left = new TreeNode(val);
                    break;
                }
                current = current.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InsertIntoBinaryTree ibt = new InsertIntoBinaryTree();
        TreeNode source = new TreeNode(4).leftAndRight(2, 7);
        source.left.leftAndRight(1, 3);
        TreeNode res = ibt.insertIntoBST(source, 5);
        TreeNode.print(res);

        source = new TreeNode(4).leftAndRight(2, 7);
        source.left.leftAndRight(1, 3);
        res = ibt.insertIntoBSTViaIter(source, 5);
        TreeNode.print(res);
    }
}

