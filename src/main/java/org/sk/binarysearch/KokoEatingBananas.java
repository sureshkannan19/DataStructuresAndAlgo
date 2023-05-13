package org.sk.binarysearch;

public class KokoEatingBananas {

	public int minEatingSpeed(int[] piles, int hours) {
		int left = 1;
		int right = piles[0];

		for (int i = 1; i < piles.length; i++) {
			right = Math.max(piles[i], right);
		}

		int eatingSpeed = right;
		while (left <= right) {
			// mid is eatingSpeed
			int tempEatingSpeed = left + (right - left) / 2;
			int tempHours = find(piles, hours, tempEatingSpeed);
			if (tempHours == -1) {
				return eatingSpeed;
			}
			if (tempHours > hours) {
				left = tempEatingSpeed + 1;
			} else {
				right = tempEatingSpeed - 1;
			}
			if (tempHours <= hours) {
				eatingSpeed = Math.min(eatingSpeed, tempEatingSpeed);
			}
		}
		return eatingSpeed;
	}

	private int find(int[] piles, int hours, int eatingSpeed) {
		int tempHours = 0;
		for (int pile : piles) {
			if (pile < eatingSpeed) {
				tempHours += 1;
			} else {
				int temp = pile / eatingSpeed;
				tempHours += temp;
				if ((temp * eatingSpeed) != pile) {
					tempHours += 1;
				}
				if (tempHours < 0) {
					return -1;
				}
			}
		}
		return tempHours;
	}

	public static void main(String[] args) {
		KokoEatingBananas keb = new KokoEatingBananas();
		System.out.println(keb.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
		System.out.println(keb.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5));
		System.out.println(keb.minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6));
		System.out.println(keb.minEatingSpeed(new int[] { 312884470 }, 312884469));
		System.out.println(keb.minEatingSpeed(new int[] { 1, 1, 1, 999999999 }, 10));
		System.out.println(keb.minEatingSpeed(new int[] { 805306368, 805306368, 805306368 }, 1000000000));
	}
}
