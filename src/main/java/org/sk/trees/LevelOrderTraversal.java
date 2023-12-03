package org.sk.trees;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return levelOrder(root, result, 0);
    }

    private List<List<Integer>> levelOrder(TreeNode root, List<List<Integer>> result, int level) {
        if (root != null) {
            if (level == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            levelOrder(root.left, result, level + 1);
            levelOrder(root.right, result, level + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode source1 = new TreeNode(3).leftAndRight(9, 20);
        source1.right.leftAndRight(15, 7);

        TreeNode source2 = new TreeNode(1).leftAndRight(2, 3);
        source2.left.leftAndRight(4, null);
        source2.right.leftAndRight(null, 5);

        TreeNode source3 = new TreeNode(1).leftAndRight(2, 3);
        source3.left.leftAndRight(4, 5);
        source3.right.leftAndRight(6, 7);
        source3.left.left.leftAndRight(8, 9);
        source3.left.right.leftAndRight(10, 11);
        source3.right.left.leftAndRight(12, 13);
        source3.right.right.leftAndRight(14, 15);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.println(lot.levelOrder(source1));
        System.out.println(lot.levelOrder(source2));
        System.out.println(lot.levelOrder(source3));
    }
}
