package org.sk.sort;

import java.util.Arrays;

public class QuickSort {

    // Space Complexity - O(1)
    // Time Complexity - Best case: O(nlogn) Worst case - O(n^2)
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionInd = partition(nums, low, high);
            quickSort(nums, low, partitionInd - 1);
            quickSort(nums, partitionInd + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[i] <= pivot && i < high) { // breaking point when element present left side is greater than pivot
                i++;
            }
            while (nums[j] > pivot && j > low) { // breaking point when element present right side is less than pivot
                j--;
            }
            if (i < j) { // swap both i and j elements
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[j];
        nums[j] = pivot;
        return j; // Based on partition index where arrays will be divided into sub array
    }

    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        sort(actual);
        System.out.println(Arrays.toString(actual));
    }
}

