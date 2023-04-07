package org.sk.arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int num : nums) {
			countMap.compute(num, (key, val) -> val != null ? val + 1 : 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> sortByOccurence = new PriorityQueue<>(
				(a, b) -> b.getValue() - a.getValue());
		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			sortByOccurence.add(entry);
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = sortByOccurence.poll().getKey();
		}
		return result;
	}

	public static void main(String[] args) {
		KFrequentElements kfe = new KFrequentElements();
		System.out.println(Arrays.toString(kfe.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
		System.out.println(Arrays.toString(kfe.topKFrequent(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(kfe.topKFrequent(new int[] { 1, 2 }, 2)));
	}
}