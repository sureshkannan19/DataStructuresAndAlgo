package org.sk.trees;


import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPreorder {

    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructBT(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode constructBT(int[] preorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int current = inorderIndexMap.get(root.val);
        int balance = current - inStart;
        root.left = constructBT(preorder, preStart + 1, preStart + balance, inStart, current - 1);
        root.right = constructBT(preorder, preStart + balance + 1, preStart + preEnd, current + 1, inEnd);
        return root;
    }


    public static void main(String[] args) {

    }

}
