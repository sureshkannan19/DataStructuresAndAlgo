package org.sk.linkedlist;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode previous = null;
		ListNode current = head; // 1, 2, 3, 4, 5, 6, 7
		while (current != null) {
			ListNode nextElement = current.next; // 2 , 3
			current.next = previous; // null , 1
			previous = current; // 1 , 2
			current = nextElement; // 2 , 3
		}
		return previous;
	}

	public static void main(String[] args) {
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode.print(rll.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
	}
}