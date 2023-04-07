package org.sk.arraysAndHashing;

public class ProductExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int zeroCount = 0;
		int product = 1;
		for (int num : nums) {
			if (num == 0) {
				zeroCount++;
			} else {
				product *= num;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (zeroCount == 1) {
				nums[i] = nums[i] != 0 ? 0 : product;
			} else if (zeroCount > 1) {
				nums[i] = 0;
			} else {
				nums[i] = product / nums[i];
			}
		}
		return nums;
	}
}