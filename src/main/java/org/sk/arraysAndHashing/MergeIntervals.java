package org.sk.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int[] previous = result.get(result.size() - 1);
            if (previous[1] < start) { // previous end is less than new beginning
                result.add(intervals[i]);
            } else if (previous[1] < end) {
                previous[1] = end;
            }
        }
        int[][] resultArr = new int[result.size()][2];
        int i = 0;
        for(int[] r: result) {
            resultArr[i++] = r;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        mi.print(mi.merge(new int[][]{{0, 1}, {2, 4}, {3, 5}, {7, 9}}));
    }

    public void print(int[][] result) {
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
