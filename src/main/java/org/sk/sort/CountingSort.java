package org.sk.sort;

import java.util.Arrays;

public class CountingSort {

    // Space Complexity - O(n) : depends on the min and max value
    // Time Complexity - Best case: O(n) Worst case - O(n): depends on the min and max value
    public static int[] countingSort(int[] numbs) {
        if (numbs.length < 2) return numbs;
        int min = numbs[0], max = numbs[0];
        for (int num : numbs) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] frequencyArray = new int[(max - min) + 1];
        for (int num : numbs) {
            frequencyArray[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < frequencyArray.length; i++) {
            while (frequencyArray[i] > 0) {
                numbs[index++] = i + min;
                frequencyArray[i]--;
            }
        }
        return numbs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(new int[]{5, 1, 6, 2, 3, 4})));
        System.out.println(Arrays.toString(countingSort(new int[]{5, 4, 2, 3, 1})));
        System.out.println(Arrays.toString(countingSort(new int[]{50, 58, 1, 27, 123, 905, 12})));
    }

}

