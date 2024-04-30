package org.sk.misc;

public class PrefixSum {

    private final int[] prefixSum;

    public PrefixSum(int[] nums) {
        this.prefixSum = nums;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? prefixSum[right] : prefixSum[right] - prefixSum[left - 1];
    }

    public static void main(String[] args) {
        PrefixSum ps = new PrefixSum(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(ps.sumRange(0, 2));
        System.out.println(ps.sumRange(2, 5));
        System.out.println(ps.sumRange(0, 5));
    }

}
