package org.sk.linkedlist;

public class RemoveNthNodeAtEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode left = dummy;
		ListNode right = head;
		// Step 1: move right pointer to n times and delay left(don't left pointer move)
		while (n > 0 && right != null) {
			right = right.next;
			n -= 1;
		}
		// Step 2: move both left and right pointers
		while (right != null) {
			right = right.next;
			left = left.next;
		}
		
		// Step 3: Where left pointer is currently in, thats the previous to the nth node to be removed.
		left.next = left.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveNthNodeAtEndOfList rn = new RemoveNthNodeAtEndOfList();
		ListNode.print(rn.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(4))), 2));
		ListNode.print(rn.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(4))), 1));
		ListNode.print(rn.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(4))), 3));
		ListNode.print(rn.removeNthFromEnd(
				new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));

	}

}
