package org.sk.trees;

import com.sun.source.tree.Tree;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode left(Integer val) {
        this.left = new TreeNode(val);
        return this.left;
    }

    public TreeNode right(Integer val) {
        this.right = new TreeNode(val);
        return this.right;
    }

    public TreeNode leftAndRight(Integer left, Integer right) {
        if (left != null) this.left = new TreeNode(left);
        if (right != null) this.right = new TreeNode(right);
        return this;
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + val + "]";
    }

    public static void print(TreeNode root) {
        if (root != null) {
            System.out.print("Current Root : " + root.val);
            System.out.print("\t Left : " + (root.left != null ? root.left.val : "NA"));
            System.out.print("\t Right : " + (root.right != null ? root.right.val : "NA"));
            System.out.println();
            print(root.left);
            print(root.right);
        }
    }

}
