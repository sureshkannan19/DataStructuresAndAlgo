package org.sk.binarysearch;

public class BinarySearch {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target)
				return mid;
			else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(new int[] { -1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(bs.search(new int[] { -1, 0, 3, 5, 9, 12 }, 2));
	}

}
