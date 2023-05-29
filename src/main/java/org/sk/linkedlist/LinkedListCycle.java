package org.sk.linkedlist;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != null && fast != null && fast.next != null) {
			if (slow == fast) { // 2 // 4 // 1 // 5
				return true;
			}
			slow = slow.next; // 2 // 3 // 4
			fast = fast.next.next; // 4 // 1 // 3 // 5
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedListCycle llc = new LinkedListCycle();
		ListNode head = new ListNode(1);
		ListNode tail = new ListNode(5, head);
		head.next = new ListNode(2, new ListNode(3, new ListNode(4, tail)));
		System.out.println(llc.hasCycle(head));

		head.next = new ListNode(2);
		System.out.println(llc.hasCycle(head));
	}

}
