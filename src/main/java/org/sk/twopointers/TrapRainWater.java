package org.sk.twopointers;

public class TrapRainWater {

	public int trap1(int[] height) {
		int end = height.length - 2;
		int min[] = new int[height.length], max[] = new int[height.length];

		int maxLeft = 0, maxRight = 0;
		for (int start = 1; start < height.length; start++, end--) {
			min[start] = maxLeft = Math.max(maxLeft, height[start - 1]);
			max[end] = maxRight = Math.max(maxRight, height[height.length - start]);
		}

		int trappedWater = 0;
		for (int i = 0; i < height.length; i++) {
			int temp = Math.min(min[i], max[i]) - height[i];
			trappedWater += temp > 0 ? temp : 0;
		}
		return trappedWater;
	}

	public int trap2(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int trappedWater = 0;

		int maxLeft = height[0], maxRight = height[height.length - 1];
		while (left <= right) {
			if (maxLeft <= maxRight) {
				trappedWater += Math.max(maxLeft - height[left], 0); // minLeft - height gives trapped water unit count
				maxLeft = Math.max(height[left], maxLeft);
				left++;
			} else {
				trappedWater += Math.max(maxRight - height[right], 0);
				maxRight = Math.max(height[right], maxRight);
				right--;
			}
		}
		return trappedWater;
	}

	public static void main(String[] args) {
		TrapRainWater trw = new TrapRainWater();
		System.out.println(trw.trap1(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trw.trap1(new int[] { 4, 2, 0, 3, 2, 5 }));
		System.out.println(trw.trap1(new int[] { 4, 2, 3 }));
		System.out.println(trw.trap1(new int[] { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 }));
		
		System.out.println(trw.trap2(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trw.trap2(new int[] { 4, 2, 0, 3, 2, 5 }));
		System.out.println(trw.trap2(new int[] { 4, 2, 3 }));
		System.out.println(trw.trap2(new int[] { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 }));
	}
}
