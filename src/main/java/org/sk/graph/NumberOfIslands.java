package org.sk.graph;

public class NumberOfIslands {

    static int row;
    static int col;

    public static int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[row - 1].length;

        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    visitIsland(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    private static void visitIsland(char[][] grid, int i, int j) {
        grid[i][j] = '*';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            visitIsland(grid, i - 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            visitIsland(grid, i, j - 1);
        }
        if (j + 1 < col && grid[i][j + 1] == '1') {
            visitIsland(grid, i, j + 1);
        }
        if (i + 1 < row && grid[i + 1][j] == '1') {
            visitIsland(grid, i + 1, j);
        }
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                }
        ));
    }
}
