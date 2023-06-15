package org.sk.linkedlist;

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int slow = 0;
		int fast = 0;

		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
//			System.out.println("Slow : " + slow + " Fast : " + fast);
			if (slow == fast) {
				break;
			}
		}

		int slow2 = 0;
		while (true) {
			slow = nums[slow];
			slow2 = nums[slow2];
//			System.out.println("Slow2 : " + slow2 + " Slow : " + slow);
			if (slow == slow2) {
				break;
			}
		}
		return slow;
	}

	public static void main(String[] args) {
		FindDuplicateNumber fdn = new FindDuplicateNumber();
//		System.out.println(fdn.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(fdn.findDuplicate(new int[] { 2, 2, 2, 2, 2 }));
	}

}
