package org.sk.linkedlist;

public class MaxTwinSum {

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        ListNode reversed = null;
        // 1, 2, 2, 1
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode nextElement = slow.next; // 2
            slow.next = reversed; // 1
            reversed = slow; // 1
            slow = nextElement;
        }

        ListNode middle = slow;
        int maxTwin = 0;
        while (reversed != null && middle != null) {
            maxTwin = Math.max(reversed.val + middle.val, maxTwin);
            middle = middle.next;
            reversed = reversed.next;
        }
        return maxTwin;
    }

    public static void main(String[] args) {
        System.out.println(pairSum(new ListNode(1).addAll(2, 2, 1)));
        System.out.println(pairSum(new ListNode(5).addAll(4, 2, 1)));
    }
}
