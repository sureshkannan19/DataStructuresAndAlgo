package org.sk.binarysearch;

public class TwoDBinarySearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        int colLeft, colRight, mid = 0;

        for (int[] ints : matrix) {
            if (ints[ints.length - 1] < target) {
                continue;
            }
            colLeft = 0;
            colRight = ints.length - 1;
            mid = (colRight - colLeft) / 2;
            while (colLeft <= colRight) {
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] < target) {
                    colLeft = mid + 1;
                } else {
                    colRight = mid - 1;
                }
                mid = colLeft + (colRight - colLeft) / 2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoDBinarySearch tbs = new TwoDBinarySearch();
        System.out.println(tbs.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 5));
    }
}
