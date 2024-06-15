package org.sk.graph;

import java.util.*;

public class DijkstraAlgorithm {

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> edgesMap = new HashMap<>();
        for (int[] edge : times) {
            edgesMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(new int[]{edge[1], edge[2]}); // Source (edge[0)) to dest (edge[1]) and its time taken(weight (edge[2]))
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));
        minHeap.add(new int[]{0, k}); // Weight(time-taken) at each Node starting from k node

        int minPath = 0;
        Set<Integer> visitedNodes = new HashSet<>();
        while (!minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            int w1 = min[0];
            int n1 = min[1];
            if (!visitedNodes.contains(n1)) {
                visitedNodes.add(n1);
                minPath = Math.max(w1, minPath);
                if (edgesMap.get(n1) != null) {
                    for (int[] entry : edgesMap.get(n1)) {
                        int n2 = entry[0];
                        int w2 = entry[1];
                        if (!visitedNodes.contains(n2)) {
                            minHeap.add(new int[]{w1 + w2, n2});
                        }
                    }
                }
            }
        }
        return visitedNodes.size() == n ? minPath : -1;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1));
    }

}

