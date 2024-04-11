package org.sk.sort;

import java.util.Arrays;

public class SelectionSort {

    // Space Complexity - O(1)
    // Time Complexity - Best case & Worst case - O(n^2)
    public int[] sort(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) { // skipping last element sort
            int min = nums[i];
            int swapInd = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    swapInd = j;
                    min = nums[j];
                }
            }
            nums[swapInd] = nums[i]; // whatever is in current index move to where the min element found and vice versa
            nums[i++] = min;
        }
        return nums;
    }

    public static void main(String[] args) {
        SelectionSort ss = new SelectionSort();
        System.out.println(Arrays.toString(ss.sort(new int[]{5, 4, 2, 3, 1})));
        System.out.println(Arrays.toString(ss.sort(new int[]{50, 58, 1, 27, 123, 905, 12})));
    }

}
