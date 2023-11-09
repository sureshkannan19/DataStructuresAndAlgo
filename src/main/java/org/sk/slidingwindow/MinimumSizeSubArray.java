package org.sk.slidingwindow;

public class MinimumSizeSubArray {

    public int minSubArrayLen(int target, int[] nums) {
        int minCount = nums.length;
        int temp = 0;
        int resInd = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            while (temp >= target) {
                minCount = Math.min(i + 1 - resInd, minCount);
                temp -= nums[resInd++];
            }
        }
        return resInd == 0 ? 0 : minCount;
    }

    public static void main(String[] args) {
        MinimumSizeSubArray ms = new MinimumSizeSubArray();
        System.out.println(ms.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(ms.minSubArrayLen(15, new int[]{5, 1, 3, 5, 10, 7, 4, 9, 2, 8}));
    }
}
