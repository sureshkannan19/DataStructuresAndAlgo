package org.sk.dp;

import java.util.Arrays;

public class MinimumFallingPath {

    private static final int[] directions = {-1, 0, 1};

    public static int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += min(matrix, i - 1, j);
            }
        }
        return Arrays.stream(matrix[matrix.length - 1]).min().getAsInt();
    }

    private static int min(int[][] matrix, int row, int col) {
        int min = Integer.MAX_VALUE;
        for (int dir : directions) {
            int c = dir + col;
            if (c >= 0 && c < matrix[row].length) {
                min = Math.min(matrix[row][c], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));
        System.out.println(minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));
    }
}
