package org.sk.stack;

import java.util.Arrays;

public class DailyTemperatures {

	public int[] dailyTemperatures(int[] temperatures) {

		int result[] = new int[temperatures.length];

		Stack stack = new Stack();
		stack.push(temperatures[0], 0);

		for (int i = 1; i < temperatures.length; i++) {
			if (stack.top().value < temperatures[i]) {
				result[stack.top().index] = i - stack.pop().index;
				while (stack.top() != null && stack.top().value < temperatures[i]) {
					result[stack.top().index] = i - stack.pop().index;
				}
			}
			stack.push(temperatures[i], i);
		}

		return result;
	}

	public static void main(String[] args) {

		DailyTemperatures tem = new DailyTemperatures();

		System.out.println(Arrays.toString(tem.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 })));
		System.out.println(Arrays.toString(tem.dailyTemperatures(new int[] { 30, 40, 50, 60 })));
		System.out.println(Arrays.toString(tem.dailyTemperatures(new int[] { 30, 60, 90 })));

		System.out.println(Arrays.toString(tem.dailyTemperatures(new int[] { 72, 70, 71, 74, 75 })));
		System.out.println(Arrays.toString(tem.dailyTemperatures(new int[] { 72, 70, 71, 75, 74 })));
	}
}