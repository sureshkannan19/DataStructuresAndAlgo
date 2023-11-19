package org.sk.linkedlist;

public class AddTwoNumLinkedList {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode result = new ListNode();
        ListNode temp = result;

        int bal = 0;
        while (l1 != null || l2 != null) {
            temp.next = new ListNode();
            temp = temp.next;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += bal;
            if (sum > 9) {
                temp.val = sum - 10;
                bal = 1;
            } else {
                temp.val = sum;
                bal = 0;
            }
            sum = 0;
        }
        if (bal == 1) {
            temp.next = new ListNode(1);
        }
        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumLinkedList adnum = new AddTwoNumLinkedList();
		ListNode.print(adnum.addTwoNumbers(new ListNode(2).addAll(4, 3), new ListNode(5).addAll(6, 4)));
		ListNode.print(adnum.addTwoNumbers(new ListNode(9).addAll(9, 9, 9, 9, 9, 9), new ListNode(9).addAll(9, 9, 9)));
    }

}