package org.sk.stack;

import java.util.LinkedList;

public class LargestRectangelInHistogram {

	public int largestRectangleArea(int[] heights) {

		int maxArea = 0;

		LinkedList<Bar> bars = new LinkedList<>();
		bars.push(new Bar(0, heights[0]));

		for (int width = 1; width < heights.length; width++) {
			Bar prevBar = bars.peek();
			if (prevBar.height <= heights[width]) {
				bars.push(new Bar(width, heights[width]));
			} else {
				while (!bars.isEmpty() && bars.peek().height > heights[width]) {
					prevBar = bars.pop();
					maxArea = Math.max(maxArea, (width - prevBar.width) * prevBar.height);
				}
				bars.push(new Bar(prevBar.width, heights[width]));
			}
		}

		// Calculating maxArea for Balance Bars with decreasing (strictly non - increasing)
		for (Bar bar : bars) {
			maxArea = Math.max(maxArea, (heights.length - bar.width) * bar.height);
		}
		return maxArea;
	}

	class Bar {

		int width;
		int height;

		public Bar(int width, int height) {
			this.width = width;
			this.height = height;
		}

	}

	public static void main(String[] args) {
		LargestRectangelInHistogram lri = new LargestRectangelInHistogram();
		System.out.println(lri.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
	}
}