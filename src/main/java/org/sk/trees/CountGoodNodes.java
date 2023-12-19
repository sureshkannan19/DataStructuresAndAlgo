package org.sk.trees;

public class CountGoodNodes {

    private int goodNodeCount = 1;

    public int goodNodes(TreeNode root) {
        goodNodeCount = 1;
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int maxPrevious) {
        if (root != null) {
            // retaining max previous at root level,
            // once counting good nodes on left side is done
            // right side node traversal starts at that point current max value considered as max previous for right side nodes
            int currMaxPrev = maxPrevious;
            if (root.left != null && root.left.val >= maxPrevious) {
                maxPrevious = root.left.val;
                goodNodeCount++;
            }
            goodNodes(root.left, maxPrevious);
            if (root.right != null && root.right.val >= currMaxPrev) {
                currMaxPrev = root.right.val;
                goodNodeCount++;
            }
            goodNodes(root.right, currMaxPrev);
        }
        return goodNodeCount;
    }

    public static void main(String[] args) {
        CountGoodNodes cn = new CountGoodNodes();
        TreeNode source = new TreeNode(3).leftAndRight(1, 4);
        source.left.left(3);
        source.right.leftAndRight(1, 5);
        System.out.println(cn.goodNodes(source));

        TreeNode source1 = new TreeNode(2).leftAndRight(null, 4);
        source1.right.leftAndRight(10, 8);
        source1.right.right.left(4);
        System.out.println(cn.goodNodes(source1));
    }
}
