package org.sk.stack;

class Node {

	int value;
	Node next;
	int min;

	Node() {
	}

	Node(int value) {
		this.value = value;
	}
}

public class MinStackViaNode {

	Node stack;
	int size;

	public MinStackViaNode() {
		stack = new Node();
		size = 0;
	}

	public void push(int val) {
		Node tmp = new Node(val);
		if (size == 0) {
			tmp.next = null;
			tmp.min = val;
		} else {
			tmp.min = Math.min(stack.min, val);
			tmp.next = stack;
		}
		stack = tmp;
		size++;
	}

	public void pop() {
		stack = stack.next;
		size--;
	}

	public int top() {
		return stack.value;
	}

	public int getMin() {
		return stack.min;
	}

	public static void main(String[] args) {
		MinStackViaNode ms = new MinStackViaNode();
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

		MinStackViaNode ms1 = new MinStackViaNode();
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
