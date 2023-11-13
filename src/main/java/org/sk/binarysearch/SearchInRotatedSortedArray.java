package org.sk.binarysearch;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[right] >= nums[mid]) {
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sr = new SearchInRotatedSortedArray();
        System.out.println(sr.search(new int[]{5, 1, 3}, 3));
        System.out.println(sr.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(sr.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(sr.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(sr.search(new int[]{1}, 0));
    }
}
