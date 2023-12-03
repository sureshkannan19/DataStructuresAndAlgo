package org.sk.trees;

import java.util.LinkedList;

public class FindMaxDepthOfBinaryTree {

    public int maxDepthViaIteration(TreeNode root) {
        int depth = 0;

        LinkedList<Pair> tree = new LinkedList<>();
        tree.push(new Pair(1, root));

        while (!tree.isEmpty()) {
            Pair temp = tree.pop();
            if (temp.root != null) {
                depth = Math.max(depth, temp.depth);
                tree.push(new Pair(temp.depth + 1, temp.root.right));
                tree.push(new Pair(temp.depth + 1, temp.root.left));
            }
        }
        return depth;
    }

     public int maxDepthViaRecursive(TreeNode root) {
        return maxDepth(root, 1, 0);
    }

    private int maxDepth(TreeNode root, int curLevel, int maxLevel) {
        if (root != null) {
            maxLevel = Math.max(curLevel, maxLevel);
            maxLevel = maxDepth(root.left, curLevel + 1, maxLevel);
            maxLevel = maxDepth(root.right, curLevel + 1, maxLevel);
        }
        return maxLevel;
    }


    public static void main(String[] args) {
        FindMaxDepthOfBinaryTree ibt = new FindMaxDepthOfBinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7));
        System.out.println(ibt.maxDepthViaIteration(root));
        System.out.println(ibt.maxDepthViaRecursive(root));
    }
}
