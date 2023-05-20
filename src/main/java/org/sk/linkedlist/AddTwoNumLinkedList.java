package org.sk.linkedlist;

public class AddTwoNumLinkedList {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int sum = 0;
		int rem = 0;
		ListNode dummy = new ListNode();
		ListNode next = dummy;

		while (l1 != null || l2 != null) {
			next.next = new ListNode();
			sum = 0;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			sum = rem + sum;
			if (sum > 9) {
				sum = sum % 10;
				rem = 1;
			} else {
				rem = 0;
			}
			next.next.val = sum;
			next = next.next;
		}

		if (rem != 0) {
			next.next = new ListNode(rem);
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		AddTwoNumLinkedList adnum = new AddTwoNumLinkedList();
		ListNode.print(adnum.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))),
				new ListNode(5, new ListNode(6, new ListNode(4)))));

	}

}