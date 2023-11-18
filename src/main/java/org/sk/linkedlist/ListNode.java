package org.sk.linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode add(int val) {
        this.next = new ListNode(val);
        return this.next;
    }

    public ListNode addAll(int... val) {
        ListNode next = this;
        for (int v : val) {
            next = next.add(v);
        }
        return this;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }
}