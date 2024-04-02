package org.sk.linkedlist;

public class DesignLinkedList {

    private static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }


    private static class MyLinkedList {

        int size = 0;
        Node head;
        Node tail;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index >= size) return -1;
            int s = 0;
            Node temp = head;
            while (s < size) {
                if (s == index) return temp.val;
                else temp = temp.next;
                s++;
            }
            return -1;
        }

        public void addAtHead(int val) {
            if (head != null) {
                Node temp = head;
                head = new Node(val, temp);
                temp.prev = head;
            } else {
                head = new Node(val);
                tail = head;
            }
            size++;
        }

        public void addAtTail(int val) {
            if (tail != null) {
                Node temp = tail;
                tail = new Node(val);
                temp.next = tail;
                tail.prev = temp;
            } else {
                tail = new Node(val);
                head = tail;
            }
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index == 0) {
                Node next = head;
                head = new Node(val, next);
                if (next != null) {
                    next.prev = head;
                }
                if (size == (index + 1)) {
                    tail = head;
                }
                size++;
                return;
            }
            if (index == (size - 1)) {
                addAtIndex(val, tail);
                size++;
                return;
            }
            if (index == size) {
                Node current = new Node(val);
                current.prev = tail;
                tail.next = current;
                tail = current;
                size++;
                return;
            }
            int s = 0;
            Node temp = head;
            while (s < size) {
                if (s == index) {
                    addAtIndex(val, temp);
                    size++;
                    return;
                }
                temp = temp.next;
                s++;
            }
        }

        private void addAtIndex(int val, Node temp) {
            Node prevNode = temp.prev;
            Node current = new Node(val, temp);
            current.prev = prevNode;
            temp.prev = current;
            if (prevNode != null) {
                prevNode.next = current;
            }
        }

        public void deleteAtIndex(int index) {
            if (index >= size) return;
            if (index == 0) {
                head = head.next;
                if (head != null) head.prev = null;
                if (size == (index + 1)) {
                    tail = head;
                }
                size--;
                return;
            }
            if (index == (size - 1)) {
                tail = tail.prev;
                if (tail != null) tail.next = null;
                size--;
                return;
            }
            int s = 0;
            Node temp = head;
            while (s < size) {
                if (s == index) {
                    Node prevNode = temp.prev;
                    prevNode.next = temp.next;
                    if(temp.next!=null) {
                        temp.next.prev = prevNode;
                    }
                    size--;
                    return;
                }
                temp = temp.next;
                s++;
            }
        }

    }

    public static void main(String[] args) {
        MyLinkedList dll = new MyLinkedList();
        dll.addAtHead(1);
        dll.addAtTail(3);
        dll.addAtIndex(1, 2);
        System.out.println(dll.get(1));
        dll.deleteAtIndex(1);
        System.out.println(dll.get(1));

        dll = new MyLinkedList();
        dll.addAtHead(1);
        dll.deleteAtIndex(0);

        dll = new MyLinkedList();
        dll.addAtHead(7);
        dll.addAtHead(2);
        dll.addAtHead(1);
        dll.addAtIndex(3, 0);
        dll.deleteAtIndex(2);
        dll.addAtHead(6);
        dll.addAtTail(4);
        System.out.println(dll.get(4));
        dll.addAtHead(4);
        dll.addAtIndex(4, 0);
        dll.addAtHead(6);
    }

}



