package org.sk.linkedlist;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode initiated = new ListNode();
		ListNode mergedList = initiated;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				mergedList.next = list1;
				list1 = list1.next;
			} else {
				mergedList.next = list2;
				list2 = list2.next;
			}
			mergedList = mergedList.next;
		}
		if (list1 != null) {
			mergedList.next = list1;
		} else if (list2 != null) {
			mergedList.next = list2;
		}
		return initiated.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists rll = new MergeTwoSortedLists();
		ListNode.print(rll.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4))),
				new ListNode(1, new ListNode(3, new ListNode(4)))));
	}
}
