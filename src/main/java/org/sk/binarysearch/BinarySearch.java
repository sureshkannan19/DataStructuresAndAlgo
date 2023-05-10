package org.sk.binarysearch;

public class BinarySearch {

	public int search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		int mid = right / 2;

		if (target < nums[left] || target > nums[right])
			return -1;

		if (nums[left] == target)
			return left;
		if (nums[right] == target)
			return right;
		if (nums[mid] == target)
			return mid;

		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			if (nums[left] == target) {
				return left;
			} else if (nums[right] == target) {
				return right;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
//		System.out.println(bs.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(bs.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
	}

}
