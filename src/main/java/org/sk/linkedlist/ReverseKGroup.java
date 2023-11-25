package org.sk.linkedlist;

public class ReverseKGroup {
    private ListNode reverse;
    private ListNode lastReversedNodeOfKGroup;

    public ListNode reverseKGroup(ListNode head, int k) {
        // take the length
        // find how many iterations required
        // use reverse logic , reverse the kth group and link it to the previous reversed k-1 group
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
        return current;
    }

    public static void main(String[] args) {
        ReverseKGroup r = new ReverseKGroup();
        ListNode.print(r.reverseKGroup(new ListNode(1).addAll(2, 3, 4, 5), 2));
        ListNode.print(r.reverseKGroup(new ListNode(1).addAll(2, 3, 4, 5), 3));
    }
}
