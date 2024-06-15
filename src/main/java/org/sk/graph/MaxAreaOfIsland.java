package org.sk.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    private int row;
    private int col;
    private int totalArea;

    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        row = grid.length;
        col = grid[row - 1].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    totalArea = 1;
                    visitIsland(grid, i, j);
                    maxArea = Math.max(maxArea, totalArea);
                }
            }
        }
        return maxArea;
    }

    private void visitIsland(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            totalArea++;
            visitIsland(grid, i - 1, j);
        }

        if (i + 1 < row && grid[i + 1][j] == 1) {
            totalArea++;
            visitIsland(grid, i + 1, j);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            totalArea++;
            visitIsland(grid, i, j - 1);
        }

        if (j + 1 < col && grid[i][j + 1] == 1) {
            totalArea++;
            visitIsland(grid, i, j + 1);
        }
    }

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int visitIslandViaBFS(int[][] grid) {
        row = grid.length;
        col = grid[row - 1].length;
        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, visitIslandViaBFS(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int visitIslandViaBFS(int[][] grid, int i, int j) {
        int sum = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        grid[i][j] = 2;
        while (!queue.isEmpty()) {
            Pair island = queue.poll();
            for (int[] dir : directions) {
                int row = dir[0] + island.row;
                int col = dir[1] + island.col;
                if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == 1) {
                    grid[row][col] = 2;
                    sum++;
                    queue.add(new Pair(row, col));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        System.out.println(ma.visitIslandViaBFS(new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1}
                }
        ));
    }

}