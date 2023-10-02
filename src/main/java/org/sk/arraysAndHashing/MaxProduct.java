package org.sk.arraysAndHashing;

public class MaxProduct {

	public int maxProduct(int[] nums) {
		int first = 0;
		int second = 0;
		for (int num : nums) {
			if (num >= first) {
				second = first;
				first = num;
			} else if (num >= second) {
				second = num;
			}
		}
		return (first - 1) * (second - 1);
	}

	public static void main(String[] args) {
		MaxProduct mp = new MaxProduct();
		System.out.println(mp.maxProduct(new int[] { 3, 4, 5, 2 }));
		System.out.println(mp.maxProduct(new int[] { 1, 5, 4, 5 }));
		System.out.println(mp.maxProduct(new int[] { 10, 2, 5, 2 }));
	}
}
