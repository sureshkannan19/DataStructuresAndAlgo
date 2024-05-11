package org.sk.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

    int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[row - 1].length;
        Queue<int[]> rottenOrangeQueue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    rottenOrangeQueue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        return orangesRotting(grid, rottenOrangeQueue, freshOranges);
    }

    private int orangesRotting(int[][] grid, Queue<int[]> rottenOrangeQueue, int freshOranges) {
        int level = 0;
        while (!rottenOrangeQueue.isEmpty() && freshOranges > 0) {
            int size = rottenOrangeQueue.size();
            while (size > 0) {
                int[] rotten = rottenOrangeQueue.poll();
                for (int[] dir : directions) {
                    int row = rotten[0] + dir[0];
                    int col = rotten[1] + dir[1];
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        freshOranges--;
                        rottenOrangeQueue.offer(new int[]{row, col});
                    }
                }
                size--;
            }
            level++;
        }
        return freshOranges != 0 ? -1 : level;
    }

    public static void main(String[] args) {
        RottenOrange ro = new RottenOrange();
        System.out.println(ro.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 0, 0},
                {0, 1, 1}
        }));

        System.out.println(ro.orangesRotting(new int[][]{
                {1, 1, 1},
                {1, 2, 0},
                {0, 1, 1}
        }));
    }

}
