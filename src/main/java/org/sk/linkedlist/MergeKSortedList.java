package org.sk.linkedlist;

public class MergeKSortedList {

    ListNode[] lists;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = new ListNode();
        ListNode temp = result;

        while (temp != null) {
            temp.next = findNode(lists);
            temp = temp.next;
        }
        return result.next;
    }

    private ListNode findNode(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int k = 0;
        ListNode temp = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && min > lists[i].val) {
                k = i;
                min = lists[i].val;
                temp = lists[i];
            }
        }
        if (lists[k] != null) {
            lists[k] = lists[k].next;
        }
        return temp;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        this.lists = lists;
        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i - 1], lists[i]);
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeKListHelper(int startIdx, int endIdx) {
        if (startIdx == endIdx) return lists[startIdx];
        else if (startIdx + 1 == endIdx) return mergeTwoLists(lists[startIdx], lists[endIdx]);
        else {
            int mid = startIdx + (endIdx - startIdx) / 2;
            return mergeTwoLists(mergeKListHelper(startIdx, mid), mergeKListHelper(mid + 1, endIdx));
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        curr.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedList m = new MergeKSortedList();
        ListNode result = m.mergeKLists(new ListNode[]{new ListNode(1).addAll(4, 5),
                new ListNode(1).addAll(3, 4),
                new ListNode(2).addAll(6)});
        ListNode.print(result);
    }
}
