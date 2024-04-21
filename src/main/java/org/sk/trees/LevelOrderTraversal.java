package org.sk.trees;

import java.util.ArrayList;
import java.util.LinkedList;
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

    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        return levelOrderIterative(root, result);
    }

    private List<List<Integer>> levelOrderIterative(TreeNode root, List<List<Integer>> result) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (level > 0 && !queue.isEmpty()) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                add(cur, queue);
                level--;
            }
            result.add(temp);
        }
        return result;
    }

    private void add(TreeNode root, LinkedList<TreeNode> queue) {
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }
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

        System.out.println(lot.levelOrderIterative(source1));
        System.out.println(lot.levelOrderIterative(source2));
        System.out.println(lot.levelOrderIterative(source3));
    }
}
