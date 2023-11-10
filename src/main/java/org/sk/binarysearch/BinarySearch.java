package org.sk.binarysearch;

public class BinarySearch {

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = right / 2;

		while (left <= right) {
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			}
			mid = ((right - left) / 2) + left;
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
//		System.out.println(bs.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(bs.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
	}

}
