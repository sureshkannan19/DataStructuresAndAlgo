package org.sk.binarysearch;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right - left) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                int temp = target;

                // Find Start Index
                int startInd = mid;
                while (temp == target && --startInd >= 0) {
                    temp = nums[startInd];
                }
                if (!(startInd + 1 <= right && nums[startInd + 1] == target)) {
                    startInd = mid;
                } else {
                    startInd++;
                }

                temp = target;

                // Find End Index
                int endInd = mid;
                while (temp == target && ++endInd <= nums.length - 1) {
                    temp = nums[endInd];
                }
                if (!(endInd - 1 >= 0 && nums[endInd - 1] == target)) {
                    endInd = mid;
                } else {
                    endInd--;
                }
                return new int[]{startInd, endInd};
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        System.out.println(Arrays.toString(sr.searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3)));
//        System.out.println(Arrays.toString(sr.searchRange(new int[]{3, 3, 3}, 1)));
//        System.out.println(Arrays.toString(sr.searchRange(new int[]{3, 3, 3}, 3)));
//        System.out.println(Arrays.toString(sr.searchRange(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(sr.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
