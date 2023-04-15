package org.sk.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();

		int left, right;
		for (int i = 0; i < nums.length; i++) {
			// to avoid duplicates
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				// to avoid duplicates
				if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
					right--;
					continue;
				}
				int temp = (nums[i] + nums[left] + nums[right]);
				if (temp > 0) {
					right--;
				} else if (temp < 0) {
					left++;
				} else {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		System.out.println(ts.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(ts.threeSum(new int[] { 0, 0, 0 }));
		System.out.println(ts.threeSum(new int[] { 0, 1, 1 }));
		System.out.println(ts.threeSum(new int[] { -2, -2, 0, 0, 2, 2 }));

	}
}