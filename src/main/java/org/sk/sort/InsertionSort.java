package org.sk.sort;

import java.util.Arrays;

public class InsertionSort {

    // Space Complexity - O(1)
    // Time Complexity - Best case: O(nlogn) Worst case - O(n^2)
    // Best case example : input array = {2, 3, 4, 5, 1} --> where only last value 1 is swapped  from right to left till it moves to 1st pos
    // Worst case example : input array = {5, 4, 3, 2, 1}  --> where all the values are swapped  from right to left till it moves to 1st pos
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) { // swap immediately right to left if min element found
                int left = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j] = left;
                j--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        InsertionSort is = new InsertionSort();
        System.out.println(Arrays.toString(is.sort(new int[]{5, 4, 2, 3, 1})));
        System.out.println(Arrays.toString(is.sort(new int[]{50, 58, 1, 27, 123, 905, 12})));
    }
}
