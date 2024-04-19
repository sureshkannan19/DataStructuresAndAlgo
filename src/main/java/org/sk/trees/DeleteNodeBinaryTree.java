package org.sk.trees;

public class DeleteNodeBinaryTree {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        TreeNode tobeDeleted = root;
        TreeNode prev = root;

        boolean left = false;
        boolean right = false;
        while (tobeDeleted != null) {
            if (tobeDeleted.val == key) {
                break;
            } else if (tobeDeleted.val > key) {
                prev = tobeDeleted;
                tobeDeleted = tobeDeleted.left;
                left = true;
                right = false;
            } else {
                prev = tobeDeleted;
                tobeDeleted = tobeDeleted.right;
                right = true;
                left = false;
            }
        }

        if (tobeDeleted == null) {
            return root;
        }

        linkChildNodesOfLeftParent(left, tobeDeleted, prev);
        linkChildNodesOfRightParent(right, tobeDeleted, prev);

        /**
         * Root node delete
         */
        if (!left && !right) {
            if (tobeDeleted.right != null) {
                root = tobeDeleted.right;
                moveNodeToLast(root, tobeDeleted.left);
            } else if (tobeDeleted.left != null) {
                root = tobeDeleted.left;
            } else {
                root = null;
            }
        }
        return root;
    }

    private void linkChildNodesOfRightParent(boolean right, TreeNode tobeDeleted, TreeNode prev) {
        if (right && tobeDeleted.right != null) {
            prev.right = tobeDeleted.right;
            moveNodeToLast(prev.right, tobeDeleted.left);
        } else if (right && tobeDeleted.left != null) {
            prev.right = tobeDeleted.left;
        } else if (right) {
            prev.right = null;
        }
    }

    private void linkChildNodesOfLeftParent(boolean left, TreeNode tobeDeleted, TreeNode prev) {
        if (left && tobeDeleted.right != null) {
            prev.left = tobeDeleted.right;
            moveNodeToLast(prev.left, tobeDeleted.left);
        } else if (left && tobeDeleted.left != null) {
            prev.left = tobeDeleted.left;
        } else if (left) {
            prev.left = null;
        }
    }

    private void moveNodeToLast(TreeNode source, TreeNode target) {
        if (target == null) return;
        TreeNode temp = source;
        while (source != null) {
            temp = source;
            source = source.left;
        }
        temp.left = target;
    }

    public static void main(String[] args) {
        DeleteNodeBinaryTree d = new DeleteNodeBinaryTree();
//        TreeNode source = new TreeNode(4).leftAndRight(2, 7);
//        source.left.leftAndRight(1, 3);
//        TreeNode res = d.deleteNode(source, 8);
//        TreeNode.print(res);

        TreeNode source = new TreeNode(5).leftAndRight(3, 6);
        source.left.leftAndRight(2, 4);
        source.right.leftAndRight(null, 7);
        TreeNode.print(d.deleteNode(source, 7));
    }
}
