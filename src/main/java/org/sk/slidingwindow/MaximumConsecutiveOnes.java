package org.sk.slidingwindow;

import java.util.LinkedList;

public class MaximumConsecutiveOnes {

    public static int longestOnes(int[] nums, int k) {
        int countZero = 0;
        int max = 0;
        int start = 0;

        // keep track of zeros
        LinkedList<Integer> zeroPos = new LinkedList<>();
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                countZero++;
                zeroPos.add(end);
            }
            if (countZero > k) {
                countZero--;
                // shift window begin position by polling first zero of current window
                start = zeroPos.poll() + 1;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
