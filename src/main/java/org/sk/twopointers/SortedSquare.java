package org.sk.twopointers;

import java.util.Arrays;

public class SortedSquare {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        while (left <= right) {
            int ls = nums[left] * nums[left];
            int rs = nums[right] * nums[right];
            if (ls > rs) {
                res[--n] = ls;
                left++;
            } else {
                res[--n] = rs;
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[]{-4, -1, 0, 3, 10}));
    }
}
