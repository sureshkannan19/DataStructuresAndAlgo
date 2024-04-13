package org.sk.sort;

public class FindKthLargestUsingQuickSort {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, k, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int k, int low, int high) {
        if (low < high) {
            int partitionInd = partition(nums, low, high);
            if (partitionInd == (k - 1)) return;
            else if (k <= partitionInd) {
                quickSort(nums, k, low, partitionInd - 1);
            } else {
                quickSort(nums, k, partitionInd + 1, high);
            }
        }
    }

    private int partition(int[] nums, int low, int high) {
        // last element is pivot
//        int pivot = nums[high];
//        int i = low;
//        int j = high;
//        // 6, 7, 8, 1
//        while (i < j) {
//            while (nums[i] > pivot && i < high) {
//                i++;
//            }
//            while (nums[j] <= pivot && j > low) {
//                j--;
//            }
//            if (i < j) {
//                int temp = nums[j];
//                nums[j] = nums[i];
//                nums[i] = temp;
//            }
//        }
//        nums[high] = nums[i];
//        nums[i] = pivot;
//        return i;

        // 1st element is pivot
        int pivot = nums[low];
        int i = low;
        int j = high;
        // 6, 7, 8, 1
        while (i < j) {
            while (nums[i] >= pivot && i < high) {
                i++;
            }
            while (nums[j] < pivot && j > low) {
                j--;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[low] = nums[j];
        nums[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        FindKthLargestUsingQuickSort f = new FindKthLargestUsingQuickSort();
        System.out.println(f.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(f.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
