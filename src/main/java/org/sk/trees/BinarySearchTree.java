package org.sk.trees;

public class BinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode temp = root;
        while(temp!=null) {
            if(temp.val == val) {
                return temp;
            } else if(temp.val < val) {
                temp = temp.right;
            }  else {
                temp = temp.left;
            }
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
