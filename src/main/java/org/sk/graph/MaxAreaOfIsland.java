package org.sk.graph;

public class MaxAreaOfIsland {

    private int row;
    private int col;
    private int totalArea;

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

    public static void main(String[] args) {
        MaxAreaOfIsland ma = new MaxAreaOfIsland();
        System.out.println(ma.maxAreaOfIsland(new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1}
                }
        ));
    }

}