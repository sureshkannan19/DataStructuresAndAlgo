package org.sk.linkedlist;

public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node add(int val, Integer next, Integer random) {
        this.next = new Node(val);
        if (next != null) {
            this.next.next = new Node(next);
        }
        if (random != null) {
            this.random = new Node(random);
        }
        return this.next;
    }

    public Node add(int val) {
        this.next = new Node(val);
        return this.next;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print("H: " + head.val + ",");
            System.out.print(head.next != null ? " N: " + head.next.val + "," : " Null ");
            System.out.print(head.random != null ? " R: " + head.random.val: " Null");
            head = head.next;
            System.out.println();
        }
        System.out.println();
    }

}
