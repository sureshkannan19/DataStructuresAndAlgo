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
        Map<Integer, Integer> topologicalOrderIndexMap = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            int currentCourse = prerequisite[0];
            if (!topologicalOrderIndexMap.containsKey(currentCourse)) {
                dfs(preRequisiteCoursesMap, topologyOrder, currentCourse, topologicalOrderIndexMap);
            }
        }
        for (int[] prerequisite : prerequisites) {
            int actualCourse = prerequisite[0]; // 0 , 1
            int prerequisiteCourse = prerequisite[1]; // 1 , 0
            if (topologicalOrderIndexMap.get(actualCourse) <= topologicalOrderIndexMap.get(prerequisiteCourse)) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(Map<Integer, List<Integer>> preRequisiteCoursesMap,
                            LinkedList<Integer> topologySorted, int at,
                            Map<Integer, Integer> topologicalOrderIndex) {
        topologicalOrderIndex.put(at, topologySorted.size());
        List<Integer> prerequisiteCourses = preRequisiteCoursesMap.get(at);
        if (prerequisiteCourses != null) {
            for (int i : prerequisiteCourses) {
                if (!topologicalOrderIndex.containsKey(i)) {
                    dfs(preRequisiteCoursesMap, topologySorted, i, topologicalOrderIndex);
                }
            }
        }
        topologySorted.push(at);
        topologicalOrderIndex.put(at, topologySorted.size());
    }

    public static void main(String[] args) {
        System.out.println(canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}));
        System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
    }
}
