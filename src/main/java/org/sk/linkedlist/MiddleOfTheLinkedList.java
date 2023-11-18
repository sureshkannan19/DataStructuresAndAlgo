package org.sk.linkedlist;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = new ListNode();
        fast.next = head.next;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList m = new MiddleOfTheLinkedList();
        ListNode.print(m.middleNode(new ListNode(1).addAll(2, 3, 4, 5, 6)));
        ListNode.print(m.middleNode(new ListNode(1).addAll(2, 3, 4, 5)));
        ListNode.print(m.middleNode(new ListNode(1).addAll(2, 3)));
    }
}
