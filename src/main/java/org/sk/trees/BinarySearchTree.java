package org.sk.trees;

import com.sun.source.tree.Tree;

public class BinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) return root;
            TreeNode result = searchBST(root.left, val);
            return result == null ? searchBST(root.right, val) : result;
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode source = new TreeNode(4).leftAndRight(2, 7);
        source.left.leftAndRight(1, 3);
        TreeNode res = bst.searchBST(source, 2);
        TreeNode.print(res);
    }
}
