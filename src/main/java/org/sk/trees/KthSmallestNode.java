package org.sk.trees;

public class KthSmallestNode {

    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallest(root, k);
    }

    private Integer findKthSmallest(TreeNode root, int k) {
        if (root != null) {
            Integer result = findKthSmallest(root.left, k);
            if (++counter == k) {
                return root.val;
            }
            return result != null ? result : findKthSmallest(root.right, k);
        }
        return null;
    }


    public static void main(String[] args) {
        KthSmallestNode k = new KthSmallestNode();
        TreeNode source = new TreeNode(3).leftAndRight(1, 4);
        source.left.right(2);
        System.out.println(k.kthSmallest(source, 1));
    }

}
