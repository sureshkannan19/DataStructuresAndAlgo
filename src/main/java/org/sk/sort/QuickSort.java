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
        int pivot = nums[low]; // taking first value as pivot
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[i] <= pivot && i < high) { // breaking point when element present left side is greater than pivot
                i++;
            }
            while (nums[j] > pivot && j > low) { // breaking point when element present right side is less than pivot
                j--;
            }
            System.out.print("Before sorting: " + Arrays.toString(nums) + " , Ith val: " + i + " , Jth val: " + j);
            // i < j --> 5 < 4 --> where index 5 is on the right side of pivot and index 4 is the pivot/partition index, threshold reached, hence stop the loop
            if (i < j) {
                // swapping element higher than pivot to right and lower than pivot to left of the pivot
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            System.out.println(" , After Sorting: " + Arrays.toString(nums));
        }
        System.out.print("Before sorting: " + Arrays.toString(nums) + " , Ith val: " + i + " , Jth val: " + j);
        nums[low] = nums[j];
        nums[j] = pivot;
        System.out.println(" , After Sorting: " + Arrays.toString(nums));
        return j; // Partition index where values on the left side are smaller and values on the right side are greater, based on this array will be divided into sub array
    }

    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        sort(actual);
        System.out.println(Arrays.toString(actual));
    }
}

