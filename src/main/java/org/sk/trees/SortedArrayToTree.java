package org.sk.trees;

public class SortedArrayToTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int left, int right, int nums[]) {
        if (left > right) {
//			System.out.println("Left: " + left + " Right: " + right + " Ignored");
            return null;
        }
        int mid = left + (right - left) / 2;
//        System.out.println("Left: " + left + " Right: " + right + " Mid: " + mid + " Value: " + nums[mid]);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1, nums);
        root.right = helper(mid + 1, right, nums);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToTree sat = new SortedArrayToTree();
//		sat.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
//		sat.sortedArrayToBST(new int[] { 1, 3 });
        TreeNode.print(sat.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5}));
    }
}
