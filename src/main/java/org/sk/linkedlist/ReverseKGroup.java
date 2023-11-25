package org.sk.linkedlist;

public class ReverseKGroup {
    private ListNode reverse;
    private ListNode lastReversedNodeOfKGroup;

    public ListNode reverseKGroup(ListNode head, int k) {
        // take the length
        // find how many iterations required
        // using reverse logic
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        int i = length / k;

        for (int j = 1; j <= i; j++) {
            head = reverse(head, k, j);
        }
        if (head != null) {
            this.lastReversedNodeOfKGroup.next = head;
        }
        return reverse;
    }

    private ListNode reverse(ListNode head, int k, int i) {
        ListNode previous = null;
        ListNode current = head;
        while (k != 0 && current != null) {
            ListNode nextNode = current.next; // 2 3
            current.next = previous; // 1 2 3
            previous = current; //  1
            current = nextNode; // 2 3
            k--;
        }
        if (i == 1) {
            // First K group List is the result
            this.reverse = previous;
        } else if (head != null) {
            // Linking previous reversed Kth group last node to reversed current K group's first Node
            // 2 1 -- Previous reversed k-1 group --> 1 is stored in lastReversedNodeOfKGroup
            // 4 3 -- current reversed k group --> linking 1 --> 4
            this.lastReversedNodeOfKGroup.next = previous;
        }
        // 1 is stored in lastReversedNodeOfKGroup
        // 3 is stored in lastReversedNodeOfKGroup
        this.lastReversedNodeOfKGroup = head;
        return current;
    }


    public ListNode reverseKGroupUsingRecursion(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < k; ++i) {
            if (tail == null) {// Less than k nodes, do nothing
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroupUsingRecursion(tail, k);
        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ReverseKGroup r = new ReverseKGroup();
        ListNode.print(r.reverseKGroup(new ListNode(1).addAll(2, 3, 4, 5), 2));
        ListNode.print(r.reverseKGroup(new ListNode(1).addAll(2, 3, 4, 5), 3));

        ListNode.print(r.reverseKGroupUsingRecursion(new ListNode(1).addAll(2, 3, 4, 5), 2));
        ListNode.print(r.reverseKGroupUsingRecursion(new ListNode(1).addAll(2, 3, 4, 5), 3));
    }
}
