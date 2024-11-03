package org.sk.arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length < 1) return Arrays.asList();
        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 1;
        for (; end < nums.length; end++) {
            if (nums[end] - 1 != nums[end - 1]) {  // current  - previous are same
                updateResult(nums, start, end, result);
                start = end;
            }
        }
        updateResult(nums, start, end, result);
        return result;
    }

    private void updateResult(int[] nums, int start, int end, List<String> result) {
        StringBuilder sb = new StringBuilder().append(nums[start]);
        if (end - 1 == start) {
            result.add(sb.toString());
        } else {
            result.add(sb.append("->").append(nums[end - 1]).toString());
        }
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        System.out.println(sr.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(sr.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
