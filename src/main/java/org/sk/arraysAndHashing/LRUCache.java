package org.sk.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private int size = 0;
    private Node head;
    private Node tail;

    Map<Integer, Node> cache = new HashMap<>();

    static class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.size = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        // 3, 2, 1
        // 2, 3, 1 
        if (Objects.nonNull(node)) {

            Node next = node.next;
            Node prev = node.prev;

            if (Objects.nonNull(prev)) {
                prev.next = next;
            }
            if (Objects.nonNull(next)) {
                next.prev = prev;
            }
            node.next = null;
            node.prev = null;
            updateHeadAndTail(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node evictedNode = null;
        if (cache.size() == size) {
            evictedNode = tail;
            tail = tail.prev;
            if (Objects.nonNull(tail)) {
                tail.next = null;
            }
        }
        if (Objects.nonNull(evictedNode)) {
            cache.remove(evictedNode.key);
        }

        Node node = new Node(key, value);
        updateHeadAndTail(node);
        cache.put(key, node);

    }

    private void updateHeadAndTail(Node node) {
        if (Objects.nonNull(head)) {
            node.next = head;
            head.prev = node;
        }
        if (Objects.isNull(tail)) {
            tail = node;
        }
        head = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//		["LRUCache","put","put","get","put","get","put","get","get","get"]
//		[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3); // two removed [(1,1), (3,3)]
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}