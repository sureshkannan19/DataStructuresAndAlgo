package org.sk.stack;

public class MinStackViaNode {

    class Node {

        int val;
        int min;
        Node next;

        Node() {
        }

    }


    private Node root;


    public void push(int val) {
        Node next;
        if (root == null) {
            root = new Node();
            root.min = val;
        } else {
            next = root;
            root = new Node();
            root.next = next;
            root.min = Math.min(val, next.min);
        }
        root.val = val;
    }

    public void pop() {
        root = root.next;
    }

    public int top() {
        return root.val;
    }

    public int getMin() {
        return root.min;
    }


    public static void main(String[] args) {
        MinStackViaNode ms = new MinStackViaNode();
        ms.push(2);
        ms.push(0);
        ms.push(3);
        ms.push(0);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());

        MinStackViaNode ms1 = new MinStackViaNode();
        ms1.push(-10);
        ms1.push(14);
        System.out.println(ms1.getMin());
        System.out.println(ms1.getMin());
        ms1.push(-20);
        System.out.println(ms1.getMin());
        System.out.println(ms1.getMin());
        System.out.println(ms1.top());
        System.out.println(ms1.getMin());
        ms1.pop();
        ms1.push(10);
        ms1.push(-7);
        System.out.println(ms1.getMin());
        ms1.push(-7);
        ms1.pop();
        System.out.println(ms1.top());
        System.out.println(ms1.getMin());
        ms1.pop();
    }
}
