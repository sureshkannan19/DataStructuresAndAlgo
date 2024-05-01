package org.sk.misc;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {

        // Approach is
        // 1. Find SubArray ==> iterate and multiply till first encounter of zero
        //      i)  multiply and store the current product in same index (dp) --> nums[i] = nums[i] * nums[i -1]
        //      ii) Keep storing the maxProduct at each iteration maxProduct = Math.max(maxProduct, nums[i])
        //      iii) find the firstNegValIdx(First Negative Values Index in current subArray), so that even number of negative integers in nums array will results in Positive maxProduct
        //      iv) Once Zero is encounter ==> divide the last value (nums[curIdx -1]) in current subArray  which is the maxProduct of that subArray with nums[firstNegValIdx] , the intention is below
        //         (i.e) [-1,4,-4,5,-2] ==> [-1, -4, 16, 80, -160] ==> Math.max(nums[curIdx - 1] / nums[firstNegValIdx], maxProduct);
        //         Note: only edge case we should divide the same index, [-2] ==> maxProduct is - 2, in above approach we should exclude curIdx != firstNegValIdx
        int maxProduct = nums[0];
        int firstNegValIdx = -1;

        if (nums[0] < 0) {
            firstNegValIdx = 0;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[i] < 0 && firstNegValIdx == -1) {
                    firstNegValIdx = i;
                }
                if (nums[i - 1] != 0) {
                    nums[i] *= nums[i - 1];
                }
            } else {
                maxProduct = getMaxProduct(firstNegValIdx, i, maxProduct, nums);
                firstNegValIdx = -1;
            }
            maxProduct = Math.max(maxProduct, nums[i]);
        }
        return getMaxProduct(firstNegValIdx, nums.length, maxProduct, nums);
    }

    private int getMaxProduct(int firstNegValIdx, int curIdx, int maxProduct, int[] nums) {
        if (firstNegValIdx != -1 && (curIdx - 1 != firstNegValIdx)) {
            maxProduct = Math.max(nums[curIdx - 1] / nums[firstNegValIdx], maxProduct);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubArray mp = new MaximumProductSubArray();
        System.out.println(mp.maxProduct(new int[]{-1, 4, -4, 5, -2, -1, -1, -2, -3}));
        System.out.println(mp.maxProduct(new int[]{-1, -2, -3, 0}));
    }
}
