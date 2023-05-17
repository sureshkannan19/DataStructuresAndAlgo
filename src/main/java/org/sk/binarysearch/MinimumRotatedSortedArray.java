package org.sk.binarysearch;

public class MinimumRotatedSortedArray {

	public int findMin(int[] nums) {
		int min = nums[0];
		if (nums[0] < nums[nums.length - 1]) {
			return min;
		}

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[right]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			min = Math.min(nums[mid], min);
		}

		return min;
	}

	public static void main(String[] args) {
		MinimumRotatedSortedArray mrsa = new MinimumRotatedSortedArray();
		System.out.println(mrsa.findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(mrsa.findMin(new int[] { 4, 5, 1, 2, 3 }));
		System.out.println(mrsa.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(mrsa.findMin(new int[] { 11, 13, 15, 17 }));
	}

}
