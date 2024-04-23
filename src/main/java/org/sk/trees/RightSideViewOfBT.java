package org.sk.trees;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewOfBT {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        rightSideView(root, rightSideView, 0);
        return rightSideView;
    }

    private void rightSideView(TreeNode root, List<Integer> rightSideView, int level) {
        if (root != null) {
            if (level <= rightSideView.size() - 1) {
                rightSideView.set(level, root.val);
            } else {
                rightSideView.add(root.val);
            }
            rightSideView(root.left, rightSideView, level + 1);
            rightSideView(root.right, rightSideView, level + 1);
        }
    }

    public static void main(String[] args) {
        RightSideViewOfBT rsv = new RightSideViewOfBT();
        TreeNode source = new TreeNode(1);
        source.left(2).leftAndRight(null, 5);
        source.right(3).leftAndRight(null, 4);
        System.out.println(rsv.rightSideView(source));
    }

}
