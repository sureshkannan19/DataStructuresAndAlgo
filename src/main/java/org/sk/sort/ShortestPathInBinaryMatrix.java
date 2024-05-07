package org.sk.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private static final Logger log = LoggerFactory.getLogger(ShortestPathInBinaryMatrix.class.getSimpleName());
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // If start or end is blocked
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[0] == n - 1 && current[1] == n - 1) {
                    return level;
                }

                for (int[] dir : directions) {
                    int newX = current[0] + dir[0];
                    int newY = current[1] + dir[1];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                        log.info("I : {}, J : {}, dist: {}", newX, newY, level + 1);
                        queue.offer(new int[]{newX, newY});
                        grid[newX][newY] = 1; // Mark as visited
                    }
                }
            }
            level++;
        }

        return -1; // If destination is unreachable
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix sp = new ShortestPathInBinaryMatrix();
        System.out.println(sp.shortestPathBinaryMatrix(new int[][]{
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0}
        }));
    }
}