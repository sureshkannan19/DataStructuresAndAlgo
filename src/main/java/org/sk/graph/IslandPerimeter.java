package org.sk.graph;

public class IslandPerimeter {

    public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    // above
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    // left
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        }));

        System.out.println(islandPerimeter(new int[][]{
                {1, 1}
        }));
    }
}
