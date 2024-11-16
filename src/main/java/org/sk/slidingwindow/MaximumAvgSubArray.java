package org.sk.slidingwindow;

public class MaximumAvgSubArray {

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAvg = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i + 1 >= k) {
                maxAvg = Math.max(maxAvg, sum / k);
                sum -= nums[i + 1 - k];
            }
        }
        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.7500
        System.out.println(findMaxAverage(new int[]{-1}, 1)); // -1.0000
    }
}
