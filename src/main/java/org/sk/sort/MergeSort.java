package org.sk.sort;

import java.util.Arrays;

public class MergeSort {

    // Space Complexity - O(n)
    // Time Complexity - Best case & worst case: O(nlogn)
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, n - mid);

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r);
    }

    private static void merge(
            int[] actual, int[] l, int[] r) {
        System.out.println(Arrays.toString(actual));
        int leftInd = 0, rightInd = 0, actualInd = 0;
        while (leftInd < l.length && rightInd < r.length) {
            if (l[leftInd] <= r[rightInd]) {
                actual[actualInd++] = l[leftInd++];
            } else {
                actual[actualInd++] = r[rightInd++];
            }
        }
        while (leftInd < l.length) {
            actual[actualInd++] = l[leftInd++];
        }
        while (rightInd < r.length) {
            actual[actualInd++] = r[rightInd++];
        }
        System.out.println(Arrays.toString(actual));
    }

    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        mergeSort(actual, actual.length);
        System.out.println(Arrays.toString(actual));
    }

}
