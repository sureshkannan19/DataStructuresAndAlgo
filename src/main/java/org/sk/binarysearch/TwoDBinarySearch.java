package org.sk.binarysearch;

public class TwoDBinarySearch {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
			return false;
		}

		int left = 0;
		int right = matrix[0].length - 1;

		int row = findRow(matrix, 0, target);

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (matrix[row][mid] == target) {
				return true;
			}
			if (target > matrix[row][mid]) {
				left = mid + 1;
			}
			if (target < matrix[row][mid]) {
				right = mid - 1;
			}
		}
		return false;
	}

	private int findRow(int[][] matrix, int row, int target) {
		if (row <= matrix.length - 1) {
			if (target <= matrix[row][matrix[0].length - 1]) {
				return row;
			}
			return findRow(matrix, row + 1, target);
		}
		// will not happen
		return -1;
	}

	public static void main(String[] args) {
		TwoDBinarySearch tbs = new TwoDBinarySearch();
		System.out.println(tbs.searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 5));
	}
}
