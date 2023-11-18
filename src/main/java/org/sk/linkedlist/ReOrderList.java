package org.sk.linkedlist;

import java.util.LinkedList;

public class ReOrderList {

    /**
     * ReorderList with Extra Space
     *
     * @param head
     */
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

    /**
     * ReorderList without Extra Space, by finding the length of the node
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        int length = 0;
        ListNode temp = head;
        // Step 1: take the length of the list
        while (temp != null) {
            temp = temp.next;
            length++;
        }

        int tempSize = 0;
        int halfSize = length / 2;

        ListNode reversed = null;
        ListNode current = head;
        // Step 2: Reverse the list after the halfSize
        // Eg: 1, 2, 3, 4, 5 --> 5, 4, 3
        while (tempSize < length) {
            tempSize++;
            if (tempSize <= halfSize) {
                current = current.next;
                continue;
            }
            ListNode nextElement = current.next; // 2 // 3
            current.next = reversed; // null // 1
            reversed = current; // 1 // 2
            current = nextElement; // 2 // 3
        }

        ListNode tempNode = head; // 1 - Modifying tempNode
        ListNode nextElement = head.next; // 2 - to store forward ListNode

        // Step 3: modifying from second node of head ListNode
        tempSize = 1;
        while (tempSize != length) {
            tempSize++;
            if (tempSize % 2 == 0) {
                ListNode last = reversed;
                tempNode.next = last; // 1-5, 2-4
                reversed = reversed.next;
            } else {
                tempNode.next = nextElement; // 5-2, 4-3
                nextElement = nextElement.next; // 3, 4
            }
            tempNode = tempNode.next; // 5, 2, 4
            tempNode.next = null;
        }
    }

    /**
     * ReorderList without Extra Space, by finding the mid node by slow and fast
     * pointers
     *
     * @param head
     */
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;

        // Eg : 1, 2, 3, 4, 5, 6, 7, 8
        // slow : 2, 3, 4, 5
        // fast : 3, 5, 7, null
        // Step 1: fast pointer is used to skip to end while slow pointer will be at mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: reverse from mid node
        // Eg : 5, 6, 7, 8 --> 8, 7, 6, 5
        ListNode previous = null; // reversed
        while (slow != null) {
            ListNode nextElement = slow.next;
            slow.next = previous;
            previous = slow;
            slow = nextElement;
        }

        ListNode current = head;
        while (previous.next != null) {
            ListNode currentForward = current.next;
            ListNode nextReverse = previous.next;
            // set two nodes
            // reverse
            current.next = previous;
            current = current.next;
            // forward
            current.next = currentForward;
            // for next iteration
            current = currentForward;
            previous = nextReverse;
        }

//		while (head != null) {
//			ListNode temp = head.next; // 2 3 null
//			head.next = previous; // 1 4 2 3
//			if (previous != null) {
//				previous = previous.next; // 3 null null
//				head.next.next = temp;
//			}
//			head = temp; // 2 3
//		}
    }

    public static void main(String[] args) {
        ReOrderList rol = new ReOrderList();

        ListNode l1 = new ListNode(1).addAll(2, 3, 4, 5);
        rol.reorderList2(l1);
        ListNode.print(l1);

        ListNode l2 = new ListNode(1).addAll(2, 3, 4, 5, 6);
        rol.reorderList2(l2);
        ListNode.print(l2);

        ListNode l3 = new ListNode(1).addAll(2, 3, 4);
        rol.reorderList2(l3);
        ListNode.print(l3);

    }
}