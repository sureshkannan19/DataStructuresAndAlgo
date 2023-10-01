package org.sk.arraysAndHashing;

public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			int next = nums[i];
			while (i < nums.length && nums[i] <= next) {
				i++;
			}
			j++;
			i--;
		}
		return j;
	}

	/**
	 * Assign values from first
	 * 
	 */
	public int removeDuplicates1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		System.out.println(rd.removeDuplicates(new int[] { 1, 1, 2 }));
		System.out.println(rd.removeDuplicates1(new int[] { 1, 1, 2 }));
	}
}