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

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(
            int[] a, int[] l, int[] r, int left, int right) {
        System.out.println(Arrays.toString(a));
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] actual = {5, 1, 6, 2, 3, 4};
        mergeSort(actual, actual.length);
        System.out.println(Arrays.toString(actual));
    }

}
