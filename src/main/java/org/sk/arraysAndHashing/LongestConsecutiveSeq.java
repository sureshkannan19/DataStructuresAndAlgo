package org.sk.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {

	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int longest = 1;
		Set<Integer> uniqueElements = new HashSet<>();
		for (int i : nums) {
			uniqueElements.add(i);
		}
		for (int i : nums) {
			if (!uniqueElements.contains(i - 1)) {
				int streak = 1;
				while (uniqueElements.contains(i + 1)) {
					streak++;
					i++;
				}
				longest = Math.max(streak, longest);
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		LongestConsecutiveSeq lcq = new LongestConsecutiveSeq();
		System.out.println(lcq.longestConsecutive(new int[] { 4, 100, 200, 1, 2, 3 }));
		System.out.println(lcq.longestConsecutive(new int[] { 0, 1, -1 }));
		System.out.println(lcq.longestConsecutive(new int[] { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 }));
	}
}