package org.sk.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> values = new HashSet<>();
		boolean isOdd = nums.length % 2 != 0;
		int start, end, i = 0;
		for (; i < nums.length / 2; i++) {
			start = nums[i];
			end = nums[nums.length - i - 1];
			if (start == end || values.contains(start) || values.contains(end)) {
				return true;
			} else {
				values.add(start);
				values.add(end);
			}
		}

		if (isOdd && values.contains(nums[i])) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicate cd = new ContainsDuplicate();
		System.out.println(cd.containsDuplicate(new int[] { 1, 2, 3, 1 }));
		System.out.println(cd.containsDuplicate(new int[] { 1, 2, 3, 4 }));
		System.out.println(cd.containsDuplicate(new int[] { 1000000000, 1000000000, 1 }));
		System.out.println(cd.containsDuplicate(new int[] { 0 }));
		System.out.println(cd.containsDuplicate(new int[] { 0, 1, 2 }));
		System.out.println(cd.containsDuplicate(new int[] { 0, 1, 1 }));
		System.out.println(cd.containsDuplicate(new int[] { 1, 5, -2, -4, 0 }));
	}
}
