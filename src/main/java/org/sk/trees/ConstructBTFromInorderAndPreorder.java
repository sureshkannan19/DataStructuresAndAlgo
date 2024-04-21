package org.sk.trees;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInorderAndPreorder {

    private static final Logger log = LoggerFactory.getLogger(ConstructBTFromInorderAndPreorder.class.getSimpleName());

    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return constructBT(preorder, 0, 0, preorder.length - 1);
    }


//    private TreeNode constructBT(int[] preorder, int preLeft, int preRight, int inLeft) {
//        if (preLeft > preRight) return null;
////        log.info("PreLeft : {} , PreRight : {} , InLeft : {}", preLeft, preRight, inLeft);
//        TreeNode root = new TreeNode(preorder[preLeft]); // 3
//        int curInorderIndex = inorderIndexMap.get(root.val); // 1
//        int balanceInorderElementsTobeProcessed = curInorderIndex - inLeft; // 1 - 0 = 1
//        root.left = constructBT(preorder, preLeft + 1, preLeft + balanceInorderElementsTobeProcessed, inLeft);
//        root.right = constructBT(preorder, preLeft + balanceInorderElementsTobeProcessed + 1, preRight, curInorderIndex + 1);
//        return root;
//    }

    // [10, 20, 40, 50, 30, 60] -- Preorder -- Root --> Left --> Right
    // [40, 20, 50, 10, 60, 30] -- Inorder -- Left --> Root --> Right
    public TreeNode constructBT(int[] preorder, int preorderCurInd, int inorderStart, int inorderEnd) {
        TreeNode node = new TreeNode(preorder[preorderCurInd]);
        int inorderCurInd = inorderIndexMap.get(preorder[preorderCurInd]);
        log.info("PreorderCurInd : {} , InorderCurInd : {} , InorderStart : {} , InorderEnd : {}, CurrentVal : {}", preorderCurInd, inorderCurInd, inorderStart, inorderEnd, node.val);
        if (inorderCurInd > inorderStart) {
            node.left = constructBT(preorder, preorderCurInd + 1, inorderStart, inorderCurInd - 1);
        }
        if (inorderCurInd < inorderEnd) {
            node.right = constructBT(preorder, (preorderCurInd + inorderCurInd - inorderStart + 1), inorderCurInd + 1, inorderEnd);
        }
        return node;
    }

    public static void main(String[] args) {
        ConstructBTFromInorderAndPreorder c = new ConstructBTFromInorderAndPreorder();
//        TreeNode.print(c.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        TreeNode.print(c.buildTree(new int[]{10, 20, 40, 50, 30, 60}, new int[]{40, 20, 50, 10, 60, 30}));
    }

}
