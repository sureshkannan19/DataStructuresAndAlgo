package org.sk.dp;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for (int n : nums) {
            if (curSum < 0) { // Reset curSum once zero is encountered
                curSum = 0;
            }
            curSum += n;
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
