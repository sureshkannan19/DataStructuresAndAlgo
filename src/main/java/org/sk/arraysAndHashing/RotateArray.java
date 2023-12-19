package org.sk.arraysAndHashing;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) return;

        // reverse
        reverse(nums, 0, nums.length - 1);

        // reverse k elements
        reverse(nums, 0, k - 1);

        // reverse rest of the elements
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7};
        ra.rotate(input, 13);
        System.out.println(Arrays.toString(input));

        input = new int[]{1, 2, 3, 4, 5, 6, 7};
        ra.rotate(input, 3);
        System.out.println(Arrays.toString(input));

        input = new int[]{1, 2};
        ra.rotate(input, 3);
        System.out.println(Arrays.toString(input));

        input = new int[]{1};
        ra.rotate(input, 2);
        System.out.println(Arrays.toString(input));
    }

}
