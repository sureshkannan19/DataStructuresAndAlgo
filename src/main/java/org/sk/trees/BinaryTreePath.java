package org.sk.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        formBinaryTreePath(root, result, new StringBuilder());
        return result;
    }

    private void formBinaryTreePath(TreeNode root, List<String> result, StringBuilder path) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            result.add(path.append(root.val).toString());
            return;
        }

        final int prev = path.length();
        formBinaryTreePath(root.left, result, path.append(root.val).append("->"));
        path.delete(prev, path.length());
        formBinaryTreePath(root.right, result, path.append(root.val).append("->"));
        path.delete(prev, path.length());
    }

    public static void main(String[] args) {
        BinaryTreePath btp = new BinaryTreePath();
        TreeNode source = new TreeNode(5).leftAndRight(2, 6);
        source.left.leftAndRight(1, 3);
        System.out.println(btp.binaryTreePaths(source));
    }
}
