package org.sk.twopointers;

public class MaxArea {

	public int maxArea(int[] height) {
		int maxArea = 0;
		int start = 0, end = height.length - 1;

		while (start < end) {
			int diff = end - start;
			if (height[start] < height[end]) {
				maxArea = Math.max(height[start] * diff, maxArea);
				start++;
			} else if (height[start] > height[end]) {
				maxArea = Math.max(height[end] * diff, maxArea);
				end--;
			} else {
				// height[start] and height[end] values are same  
				maxArea = Math.max(height[end] * diff, maxArea);
				start++;
				end--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		MaxArea ma = new MaxArea();
		System.out.println(ma.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

}