package org.sk.trees;


import java.util.HashSet;
import java.util.Set;

public class FindLowestCommonAncestor {

    // leetcode solution need to check
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val), max = Math.max(p.val, q.val);
        while (root != null) {
            int curr = root.val;
            if (min < curr && max < curr) {
                root = root.left;
            } else if (min > curr & max > curr) {
                root = root.right;
            } else {
                break;
            }
        }

        return root;
    }

    private int lastCrossed = 0;

    // my solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lastCrossed = root.val;
        Set<Integer> sorted = new HashSet<>();
        findNode(root, p, sorted);
        findNode(root, q, sorted);
        return new TreeNode(lastCrossed);
    }

    private TreeNode findNode(TreeNode root, TreeNode target, Set<Integer> lastCrossed) {
        if (root != null) {
            if (root.val == target.val) {
                updateLastCrossed(root, lastCrossed);
                return root;
            } else if (root.val < target.val) {
                updateLastCrossed(root, lastCrossed);
                return findNode(root.right, target, lastCrossed);
            } else {
                updateLastCrossed(root, lastCrossed);
                return findNode(root.left, target, lastCrossed);
            }
        }
        return null;
    }

    private void updateLastCrossed(TreeNode root, Set<Integer> sorted) {
        // find the last same path crossed by both p and q
        if (!sorted.add(root.val)) {
            lastCrossed = root.val;
        }
    }

    public static void main(String[] args) {
        FindLowestCommonAncestor fla = new FindLowestCommonAncestor();

        TreeNode root = new TreeNode(6).leftAndRight(2, 8);
        root.left.leftAndRight(0, 4);
        root.right.leftAndRight(7, 9);
        root.left.right.leftAndRight(3, 5);

        TreeNode.print(fla.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)));
    }
}
