package org.sk.misc;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap currentMax and currentMin when encountering a negative number
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);

            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubArray mp = new MaximumProductSubArray();
//        System.out.println(mp.maxProduct(new int[]{-1, 4, -4, 5, -2, -1, -1, -2, -3}));
        System.out.println(mp.maxProduct(new int[]{0, 2, 2, 2, -2, 2, 2, 2}));
//        System.out.println(mp.maxProduct(new int[]{-1, -2, -3, 0}));
    }
}
