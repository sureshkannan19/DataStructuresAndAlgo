package org.sk.linkedlist;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalf = head;
        ListNode secondHalf = new ListNode();
        secondHalf.next = head.next;


        ListNode previous = null;
        ListNode temp = null;
        while (true) {
            if (secondHalf == null) { //even
                break;
            }
            if (secondHalf.next == null) { //odd
                firstHalf = firstHalf.next;
                break;
            }

            temp = firstHalf;
            firstHalf = firstHalf.next;
            temp.next = previous;
            previous = temp;

            secondHalf = secondHalf.next.next;
        }


        secondHalf = firstHalf;
        while (previous != null && secondHalf != null) {
            if (previous.val != secondHalf.val) {
                return false;
            }
            previous = previous.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList p = new PalindromeLinkedList();
        System.out.println(p.isPalindrome(new ListNode(1).addAll(0, 1)));
        System.out.println(p.isPalindrome(new ListNode(1).addAll(0, 1, 0, 1)));
        System.out.println(p.isPalindrome(new ListNode(1).addAll(2, 3, 3, 2, 1)));
        System.out.println(p.isPalindrome(new ListNode(1).addAll(2, 2, 1)));
        System.out.println(p.isPalindrome(new ListNode(1).addAll(2, 3)));
    }
}
