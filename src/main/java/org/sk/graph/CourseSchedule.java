package org.sk.graph;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;

        // Create a map to hold the list of prerequisites for each course
        Map<Integer, List<Integer>> preRequisiteCoursesMap = new HashMap<>();
        for (int[] courses : prerequisites) {
            preRequisiteCoursesMap.computeIfAbsent(courses[0], v -> new ArrayList<>()).add(courses[1]);
        }

        // Data structures to keep track of course visitation status
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        // Check for cycles in the graph
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course] && hasCycle(course, preRequisiteCoursesMap, visited, onPath)) {
                return false;
            }
        }
        return true;
    }

    // Helper function to detect cycles in the graph using DFS
    private static boolean hasCycle(int course, Map<Integer, List<Integer>> preRequisiteCoursesMap,
                                    boolean[] visited, boolean[] onPath) {
        if (onPath[course]) return true; // cycle detected
        if (visited[course]) return false; // already checked and no cycle

        visited[course] = true;
        onPath[course] = true;

        // Check all prerequisite courses
        List<Integer> prerequisites = preRequisiteCoursesMap.get(course);
        if (prerequisites != null) {
            for (int prereq : prerequisites) {
                if (hasCycle(prereq, preRequisiteCoursesMap, visited, onPath)) {
                    return true;
                }
            }
        }
        // Backtrack
        onPath[course] = false;
        return false;
    }


    public static void main(String[] args) {
        System.out.println(canFinish(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}));
        System.out.println(canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(canFinish(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}}));
    }
}
