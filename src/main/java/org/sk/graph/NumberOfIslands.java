package org.sk.graph;

public class NumberOfIslands {

    static int row;
    static int col;

    static int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

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
        for (int[] dir : directions) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[row].length && grid[row][col] == '1') {
                visitIsland(grid, row, col);
            }
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
