package org.sk.arraysAndHashing;

public class RotateImage {

    public void rotateMatrix(int[][] matrix) {
        if (matrix.length > 0 && matrix.length != matrix[0].length) {
            return;
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[row].length; col++) {
                int temp = matrix[col][row];
                matrix[col][row] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length / 2; col++) {
                int temp = matrix[row][matrix.length - 1 - col];
                matrix[row][matrix.length - 1 - col] = matrix[row][col];
                matrix[row][col] = temp;
            }
        }
        print(matrix);
    }

    private void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateImage rot = new RotateImage();
        rot.rotateMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        rot.rotateMatrix(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }


}
