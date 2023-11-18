package org.sk.linkedlist;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = new ListNode();
		ListNode lastNode = result;

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				lastNode.next = list1;
				list1 = list1.next;
			} else {
				lastNode.next = list2;
				list2 = list2.next;
			}
			lastNode = lastNode.next;
		}

		ListNode l;
		if ((l = list1) != null || (l = list2) != null) {
			lastNode.next = l;
		}
		return result.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists rll = new MergeTwoSortedLists();
		ListNode.print(rll.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
				new ListNode(1, new ListNode(3, new ListNode(4)))));
	}
}
