package org.sk.stack;

import java.util.LinkedList;

public class MinStack {

	LinkedList<Integer> stack;
	LinkedList<Integer> minStack;
	int min = 0;

	public MinStack() {
		stack = new LinkedList<>();
		minStack = new LinkedList<>();
	}

	public void push(int val) {
		stack.push(val);
		if (!minStack.isEmpty()) {
			min = Math.min(val, min);
		} else {
			min = val;
		}
		minStack.push(min);
	}

	public void pop() {
		stack.pop();
		Integer value = minStack.pop();
		if (value != null && value.equals(min) && !minStack.isEmpty()) {
			min = minStack.peek();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(0);
		ms.push(3);
		ms.push(0);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.getMin());

		MinStack ms1 = new MinStack();
		ms1.push(-10);
		ms1.push(14);
		System.out.println(ms1.getMin());
		System.out.println(ms1.getMin());
		ms1.push(-20);
		System.out.println(ms1.getMin());
		System.out.println(ms1.getMin());
		System.out.println(ms1.top());
		System.out.println(ms1.getMin());
		ms1.pop();
		ms1.push(10);
		ms1.push(-7);
		System.out.println(ms1.getMin());
		ms1.push(-7);
		ms1.pop();
		System.out.println(ms1.top());
		System.out.println(ms1.getMin());
		ms1.pop();
	}
}
