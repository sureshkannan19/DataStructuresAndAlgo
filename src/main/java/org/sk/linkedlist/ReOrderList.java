package org.sk.linkedlist;

import java.util.LinkedList;

public class ReOrderList {

	public void reorderList(ListNode head) {
		int size = 0;
		LinkedList<ListNode> reverse = new LinkedList<>();
		ListNode temp = head;
		while (temp != null) {
			reverse.push(new ListNode(temp.val));
			temp = temp.next;
			size++;
		}

		ListNode tempNode = head; // 1 - Modifying tempNode
		ListNode nextElement = head.next; // 2 - to store forward ListNode

		// modifying from second node of head ListNode
		int tempSize = 1;
		while (tempSize != size) {
			tempSize++;
			if (tempSize % 2 == 0) {
				ListNode last = reverse.poll();
				tempNode.next = last; // 1-5, 2-4
			} else {
				tempNode.next = nextElement; // 5-2, 4-3
				nextElement = nextElement.next; // 3, 4
			}
			tempNode = tempNode.next; // 5, 2, 4
			tempNode.next = null;
		}
	}

	public static void main(String[] args) {
		ReOrderList rol = new ReOrderList();
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		rol.reorderList(head);
		ListNode.print(head);

		System.out.println();

		head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
		rol.reorderList(head);
		ListNode.print(head);
	}
}