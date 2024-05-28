package org.sk.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public void deleteDups(LinkedListLL list) {
        Set<Integer> uniqueElements = new HashSet<>();
        Node temp = list.head;
        Node prev = null;
        while (temp != null) {
            if (uniqueElements.contains(temp.value)) {
                prev.next = temp.next;
                list.size--;
            } else {
                uniqueElements.add(temp.value);
            }
            prev = temp;
            temp = temp.next;
        }
    }

//    public void returnNthNode(LinkedListLL list, int nodeNum) {
//        Node temp = list.head;
//        Node prev = null;
//        while (temp != null) {
//            if (uniqueElements.contains(temp.value)) {
//                prev.next = temp.next;
//                list.size--;
//            } else {
//                uniqueElements.add(temp.value);
//            }
//            prev = temp;
//            temp = temp.next;
//        }
//    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        LinkedListLL list = new LinkedListLL();
        list.createLL(1);
        list.insertNode(2); list.insertNode(3); list.insertNode(2); list.insertNode(4);
        rd.deleteDups(list);

    }
    private static class LinkedListLL {
        public Node head;
        public Node tail;
        public int size;

        public void createLL(int nodeValue) {
            Node newNode = new Node();
            newNode.value = nodeValue;
            newNode.next = null;
            head = newNode;
            tail = newNode;
            size = 1;
        }

        public void insertNode(int nodeValue) {
            Node newNode = new Node();
            newNode.value = nodeValue;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            size++;
        }

        public void traversalLL() {
            Node tempNode = head;
            for (int i =0; i<size; i++) {
                System.out.print(tempNode.value);
                if (i != size -1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }

    }

    private static class Node {
        public int value;
        public Node next;
        public Node prev;
    }

}

