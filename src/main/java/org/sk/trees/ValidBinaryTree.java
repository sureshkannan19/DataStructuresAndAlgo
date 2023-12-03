package org.sk.trees;

public class ValidBinaryTree {

    Integer previous;

    public boolean isValidBST(TreeNode root) {
        // go to the leaf node on left and store it as previous
        // level up and validate whether the current val is greater than previous
        if (root != null) {
            return inorderTraversal(root);
        }
        return true;
    }

    private boolean inorderTraversal(TreeNode root) {
        if (root != null) {
            if (inorderTraversal(root.left)) {
                if (previous == null) {
                    previous = root.val; // last leaf node
                } else {
                    if (root.val <= previous) {
                        return false;
                    } else {
                        previous = root.val;
                    }
                }
            } else {
                return false;
            }
            return inorderTraversal(root.right);
        }
        return true;
    }


    public static void main(String[] args) {
        ValidBinaryTree vbt = new ValidBinaryTree();
        TreeNode source = new TreeNode(4).leftAndRight(2, 6);
        source.left.leftAndRight(1, 3);
        source.right.leftAndRight(5, 7);
        System.out.println(vbt.isValidBST(source));

        TreeNode source1 = new TreeNode(5).leftAndRight(1, 4);
        source1.right.leftAndRight(3, 6);
        System.out.println(vbt.isValidBST(source1));

        TreeNode source2 = new TreeNode(5).leftAndRight(4, 6);
        source2.right.leftAndRight(3, 7);
        System.out.println(vbt.isValidBST(source2));

        TreeNode source4 = new TreeNode(32).leftAndRight(26, 47);
        source4.left.left(19).right(27);
        source4.right.right(56);
        System.out.println(vbt.isValidBST(source4));

        TreeNode source5 = new TreeNode(2).leftAndRight(2, 2);
        System.out.println(vbt.isValidBST(source5));
    }
}