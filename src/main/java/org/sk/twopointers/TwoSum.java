package org.sk.twopointers;

import java.util.Arrays;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum > target) {
				end--;
			} else if (sum < target) {
				start++;
			} else {
				return new int[] { start + 1, end + 1 };
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
