package org.sk.graph;

import java.util.*;

public class TopologicalSort {

    public static void topologySort(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preRequisiteCoursesMap = new HashMap<>();
        for (int[] courses : prerequisites) {
            preRequisiteCoursesMap.computeIfAbsent(courses[0], v -> new ArrayList<>()).add(courses[1]);
        }
        LinkedList<Integer> topologyOrder = new LinkedList<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] prerequisite : prerequisites) {
            int currentCourse = prerequisite[0];
            if (!visited[currentCourse]) {
                dfs(preRequisiteCoursesMap, topologyOrder, currentCourse, visited);
            }
        }
        System.out.println(topologyOrder);
    }

    private static void dfs(Map<Integer, List<Integer>> preRequisiteCoursesMap,
                            LinkedList<Integer> topologySorted, int at, boolean[] visited) {
        visited[at] = true;
        List<Integer> prerequisiteCourses = preRequisiteCoursesMap.get(at);
        if (prerequisiteCourses != null) {
            for (int i : prerequisiteCourses) {
                if (!visited[i]) {
                    dfs(preRequisiteCoursesMap, topologySorted, i, visited);
                }
            }
        }
        topologySorted.push(at);
    }


    public static void main(String[] args) {
        topologySort(4, new int[][]{{0, 1}, {1, 2}, {2, 3}});
        topologySort(2, new int[][]{{0, 1}, {1, 0}});
        topologySort(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}});
        topologySort(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}});
    }
}
