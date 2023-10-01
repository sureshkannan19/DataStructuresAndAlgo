package org.sk.stack;

public class Stack {

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
