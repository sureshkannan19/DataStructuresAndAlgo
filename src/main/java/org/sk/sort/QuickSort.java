package org.sk.sort;

import java.util.Arrays;

public class QuickSort {

    // Space Complexity - O(1)
    // Time Complexity - Best case: O(nlogn) Worst case - O(n^2)
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int partitionInd = partition(nums, start, end);
            quickSort(nums, start, partitionInd - 1);
            quickSort(nums, partitionInd + 1, end);
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start]; // taking first value as pivot
        int i = start;
        int j = end;
        while (i < j) {
            while (nums[i] <= pivot && i < end) { // breaking point when element present left side is greater than pivot
                i++;
            }
            while (nums[j] > pivot && j > start) { // breaking point when element present right side is less than pivot
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
        System.out.print("Before sorting outside: " + Arrays.toString(nums) + " , Ith val: " + i + " , Jth val: " + j);
        nums[start] = nums[j];
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

