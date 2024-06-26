package org.sk.graph;

import java.util.*;

public class CourseScheduleTopologicalSort {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 1) return true;

        Map<Integer, List<Integer>> preRequisiteCoursesMap = new HashMap<>();
        for (int[] courses : prerequisites) {
            preRequisiteCoursesMap.computeIfAbsent(courses[0], v -> new ArrayList<>()).add(courses[1]);
        }

        LinkedList<Integer> topologyOrder = new LinkedList<>();
        int[] visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int currentCourse = prerequisite[0];
            if (visited[currentCourse] == 0) {
                dfs(preRequisiteCoursesMap, topologyOrder, visited, currentCourse);
            }
        }

        Map<Integer, Integer> topologicalOrderIndex = new HashMap<>();
        for (int i = 0; i < topologyOrder.size(); i++) {
            topologicalOrderIndex.put(topologyOrder.get(i), i);
        }

        for (int[] prerequisite : prerequisites) {
            int actualCourse = prerequisite[0]; // 0 , 1
            int prerequisiteCourse = prerequisite[1]; // 1 , 0
            if (topologicalOrderIndex.get(actualCourse) >= topologicalOrderIndex.get(prerequisiteCourse)) {
                return false;
            }
        }
//        System.out.println(topologyOrder);
        return true;
    }

    private static void dfs(Map<Integer, List<Integer>> preRequisiteCoursesMap,
                            LinkedList<Integer> topologySorted, int[] visited, int at) {
        visited[at] = 1;
        List<Integer> prerequisiteCourses = preRequisiteCoursesMap.get(at);
        if (prerequisiteCourses != null) {
            for (int i : prerequisiteCourses) {
                if (visited[i] == 0) {
                    dfs(preRequisiteCoursesMap, topologySorted, visited, i);
                }
            }
        }
        topologySorted.push(at);
    }
    public static void main(String[] args) {
        System.out.println(canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}));
        System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
    }
}
