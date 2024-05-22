package org.sk.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int sum = 0;
        freq.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum - k;
            count += freq.getOrDefault(rem, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1); // Prefix sum(i, j) in map
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1, 2, 3}, 3)); // 2
        System.out.println(subarraySum(new int[] {0, 0}, 0)); // 3
    }
}
