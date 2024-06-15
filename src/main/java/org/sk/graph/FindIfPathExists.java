package org.sk.graph;

import java.util.*;

public class FindIfPathExists {

    public static boolean validPath1(int n, int[][] edges, int source, int destination) {
        // {0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}
        if (edges.length == 0) return true;
        boolean[] visited = new boolean[n];
        visited[source] = true;
        // Loop until there are no changes in the visited nodes
        while (true) {
            boolean flag = false; // Flag to track if any new nodes are visited in this iteration
            // Traverse through each edge
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1]; // Extracting vertices from the edge
                // If one of the vertices is visited and the other is not, mark both as visited
                if (visited[u] != visited[v]) {
                    visited[u] = visited[v] = true; // Mark both vertices as visited
                    flag = true; // Set the flag to true, indicating a change in visited nodes
                    // If either of the vertices is the destination, return true
                    if (u == destination || v == destination) {
                        System.out.println("U :" + u + "  V : " + v);
                        return true;
                    }
                }
            }
            // If no new nodes are visited in this iteration, break the loop
            if (!flag) break;
        }
        // If the destination is not reachable from the source, return false
        return false;
    }

    static int dest;

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        dest = destination;
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(source);
        return isConnected(visitedNodes, graph, source);
    }

    private static boolean isConnected(Set<Integer> visitedNodes, Map<Integer, List<Integer>> graph, int source) {
        if (source == dest) return true;
        for (Integer neighbor : graph.get(source)) {
            if (!visitedNodes.contains(neighbor)) {
                visitedNodes.add(neighbor);
                if (isConnected(visitedNodes, graph, neighbor)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validPathViaIterativeDFS(int n, int[][] edges, int source, int destination) {
        dest = destination;
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(source);
        return isConnectedViaItrDFS(visitedNodes, graph, source);
    }

    private static boolean isConnectedViaItrDFS(Set<Integer> visitedNodes, Map<Integer, List<Integer>> graph, int source) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int node = stack.poll();
            if (node == dest) return true;
            for (Integer neighbor : graph.get(node)) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    public static boolean validPathViaIterativeBFS(int n, int[][] edges, int source, int destination) {
        dest = destination;
        if (source == destination) return true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(source);
        return isConnectedViaItrBFS(visitedNodes, graph, source);
    }

    private static boolean isConnectedViaItrBFS(Set<Integer> visitedNodes, Map<Integer, List<Integer>> graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.pop();
            if (node == dest || graph.get(node).contains(dest)) return true;
            for (Integer neighbor : graph.get(node)) {
                if (!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(validPath(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));

        System.out.println(validPathViaIterativeDFS(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(validPathViaIterativeDFS(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));

        System.out.println(validPathViaIterativeBFS(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(validPathViaIterativeBFS(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));

        System.out.println(validPath1(10, new int[][]{{0, 7}, {0, 8}, {6, 1}, {2, 0}, {0, 4}, {5, 8}, {4, 7}, {1, 3}, {3, 5}, {6, 5}}, 7, 5));
    }
}
