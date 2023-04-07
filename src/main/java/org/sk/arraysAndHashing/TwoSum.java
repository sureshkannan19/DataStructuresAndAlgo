package org.sk.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> sumMap = new HashMap<>(nums.length - 1, 1f);
		for (int i = 0; i < nums.length; i++) {
			Integer index = sumMap.get(target - nums[i]);
			if (index == null) {
				sumMap.put(nums[i], i);
			} else {
				return new int[] { index, i };
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		System.out.println(Arrays.toString(ts.twoSum(new int[] { 3, 3 }, 6)));
		System.out.println(Arrays.toString(ts.twoSum(new int[] { 1, 2, 3, 4 }, 6)));
	}
}
