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

    public TreeNode insertIntoBSTViaIteration(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode temp = root;
        TreeNode prev = root;
        while (temp != null) {
            prev = temp;
            if (temp.val > val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
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
        res = ibt.insertIntoBSTViaIteration(source, 5);
        TreeNode.print(res);
    }
}

