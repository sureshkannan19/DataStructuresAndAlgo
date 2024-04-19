package org.sk.trees;

public class DeleteNodeBinaryTreeViaReplaceValue {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            root.val = cur.val;
//            System.out.println("Source Value : " + root.val +  " And Root Val :" + root.val);
            root.right = deleteNode(root.right, root.val);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteNodeBinaryTreeViaReplaceValue d = new DeleteNodeBinaryTreeViaReplaceValue();
//        TreeNode source = new TreeNode(4).leftAndRight(2, 7);
//        source.left.leftAndRight(1, 3);
//        TreeNode res = d.deleteNode(source, 8);
//        TreeNode.print(res);

        TreeNode source = new TreeNode(5).leftAndRight(3, 6);
        source.left.leftAndRight(2, 4);
        source.right.leftAndRight(null, 7);
        TreeNode.print(d.deleteNode(source, 3));
    }
}
