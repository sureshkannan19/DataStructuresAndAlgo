package org.sk.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheViaLinkedHashMap {

	private Map<Integer, Integer> cacheMap;

	public LRUCacheViaLinkedHashMap(int capacity) {
		this.cacheMap = new LinkedHashMap<>(capacity, 1f, true) {

			private static final long serialVersionUID = 4944780360881745851L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size() > capacity;
			}
		};
	}

	public int get(int key) {
		return cacheMap.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		cacheMap.put(key, value);
	}

	public static void main(String[] args) {
		LRUCacheViaLinkedHashMap cache = new LRUCacheViaLinkedHashMap(2);
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
