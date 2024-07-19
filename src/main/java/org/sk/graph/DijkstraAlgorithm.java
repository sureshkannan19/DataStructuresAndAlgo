package org.sk.graph;

import java.util.*;

public class DijkstraAlgorithm {

    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(new int[]{edge[1], edge[2]}); // Source (edge[0)) to dest (edge[1]) and its time taken(weight (edge[2]))
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(arr -> arr[0]));
        minHeap.add(new int[]{0, k}); // Weight(time-taken) at each Node starting from k node

        int maxTime = 0;
        Set<Integer> visitedNodes = new HashSet<>();
        while (!minHeap.isEmpty()) {
            int[] min = minHeap.poll();
            int currentTime = min[0];
            int currentNode = min[1];

            if (!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode);
                maxTime = Math.max(currentTime, maxTime);

                List<int[]> neighbors = graph.get(currentNode);
                if (neighbors != null) {
                    for (int[] neighbor : neighbors) {
                        int nextNode = neighbor[0];
                        int travelTime = neighbor[1];
                        if (!visitedNodes.contains(nextNode)) {
                            minHeap.add(new int[]{currentTime + travelTime, nextNode});
                        }
                    }
                }
            }
        }
        return visitedNodes.size() == n ? maxTime : -1;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 5}}, 3, 2));
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1));
    }

}

