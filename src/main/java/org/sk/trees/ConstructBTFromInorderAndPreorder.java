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

    // [10, 20, 40, 50, 30, 60] -- Preorder -- Root --> Left --> Right
    // [40, 20, 50, 10, 60, 30] -- Inorder -- Left --> Root --> Right
    public TreeNode constructBT(int[] preorder, int preorderCurInd, int inorderStart, int inorderEnd) {
        TreeNode node = new TreeNode(preorder[preorderCurInd]);
        int inorderCurInd = inorderIndexMap.get(preorder[preorderCurInd]);
        if (inorderCurInd > inorderStart) {
            node.left = constructBT(preorder, preorderCurInd + 1, inorderStart, inorderCurInd - 1);
        }
        if (inorderCurInd < inorderEnd) {
            node.right = constructBT(preorder, (preorderCurInd + 1) + inorderCurInd - inorderStart, inorderCurInd + 1, inorderEnd);
        }
        log.info("PreorderCurInd : {} , InorderCurInd : {} , InorderStart : {} , InorderEnd : {}, CurrentVal : {}", preorderCurInd, inorderCurInd, inorderStart, inorderEnd, node.val);
        return node;
    }

    public static void main(String[] args) {
        ConstructBTFromInorderAndPreorder c = new ConstructBTFromInorderAndPreorder();
//        TreeNode.print(c.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        TreeNode.print(c.buildTree(new int[]{10, 20, 40, 50, 30, 60}, new int[]{40, 20, 50, 10, 60, 30}));
    }

}
