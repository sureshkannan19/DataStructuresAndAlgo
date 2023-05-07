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
				updateStack(result, i, stack, temperatures[i]);
			}
			stack.push(temperatures[i], i);
		}

		return result;
	}

	private void updateStack(int[] result, int curInd, Stack stack, int curTemp) {
		while (stack.top() != null && stack.top().value < curTemp) {
			result[stack.top().index] = curInd - stack.pop().index;
			updateStack(result, curInd, stack, curTemp);
		}

	}

	private class Stack {

		Node stack;
		int size;

		public void push(int val, int index) {
			Node tmp = new Node(val, index);
			if (size != 0) {
				tmp.next = stack;
				stack = tmp;
			}
			stack = tmp;
			size++;
		}

		public Node pop() {
			Node temp = stack;
			stack = stack.next;
			size--;
			return temp;
		}

		public Node top() {
			return stack;
		}
	}

	private class Node {

		int value;
		Node next;
		int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}

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