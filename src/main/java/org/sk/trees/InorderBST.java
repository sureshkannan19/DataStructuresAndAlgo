package org.sk.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InorderBST {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalIterative(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.val);
            inorderTraversal(root.right, result);
        }
    }

    private void inorderTraversalIterative(TreeNode root, List<Integer> result) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root != null) {
                result.add(root.val);
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        InorderBST ibt = new InorderBST();
        TreeNode source = new TreeNode(1).leftAndRight(null, 3);
        source.right.left(2);
        System.out.println(ibt.inorderTraversal(source));
    }
}
