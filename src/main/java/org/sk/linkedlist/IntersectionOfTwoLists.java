package org.sk.linkedlist;

public class IntersectionOfTwoLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int headALen = length(headA);
		int headBLen = length(headB);

		if (headALen > headBLen) {
			headA = trimNode(headA, headALen - headBLen);
		} else if (headALen < headBLen) {
			headB = trimNode(headB, headBLen - headALen);
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private ListNode trimNode(ListNode head, int trimSize) {
		while (trimSize > 0) {
			head = head.next;
			trimSize--;
		}
		return head;
	}

	private int length(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		IntersectionOfTwoLists inter = new IntersectionOfTwoLists();
		ListNode intersect = new ListNode(5);
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, intersect)));
		ListNode list2 = new ListNode(1, new ListNode(3, intersect));
		ListNode.print(inter.getIntersectionNode(list1, list2));

	}
}
