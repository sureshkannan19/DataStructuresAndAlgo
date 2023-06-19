package org.sk.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private Map<Integer, Node> cacheMap;
	private int capacity = 0;
	private LinkedList cacheTrail = new LinkedList();

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<>(capacity, 1f);
	}

	public int get(int key) {
		Node node = cacheMap.get(key);
		if (node != null) {
			cacheTrail.unLink(node);
			cacheTrail.addToHead(node);
		}
		return node != null ? node.val : -1;
	}

	public void put(int key, int value) {
		Node node = cacheMap.get(key);
		if (node != null) {
			node.val = value;
		} else {
			node = new Node(key, value);
			if (capacity == cacheMap.size()) {
				Node leastUsedNode = cacheTrail.getAndRemoveLeastUsedNode();
				if (leastUsedNode != null) {
					cacheMap.remove(leastUsedNode.key);
				}
			}
			cacheMap.put(key, node);
		}
		cacheTrail.unLink(node);
		cacheTrail.addToHead(node);
	}

	private class LinkedList {

		// last added or accessed element is pushed here
		private Node head;

		// least used element is pushed here
		private Node tail;

		private void addToHead(Node node) {
			if (head != null) {
				node.next = head;
				head.previous = node;
			}
			if (tail == null) {
				tail = node;
			}
			head = node;
		}

		private Node getAndRemoveLeastUsedNode() {
			Node temp = tail;
			if (tail != null) {
				unLink(tail);
			}
			return temp;
		}

		private void unLink(Node item) {
			Node prev = item.previous;
			Node next = item.next;
			// 2, 3, 4 --> if 3 is the middle , then unLink 2 --> 4
			if (prev != null) {
				prev.next = next;
			}

			if (next != null) {
				next.previous = prev;
			}

			if (head == item) {
				head = next; // or head.next
			}

			if (tail == item) {
				tail = prev; // or tail.previous
			}

			// dereferencing
			item.previous = null;
			item.next = null;
		}

	}

	private class Node {

		private int key;
		private int val;
		private Node next;
		private Node previous;

		public Node(int key, int value) {
			this.key = key;
			this.val = value;
		}

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
