package org.sk.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FormSubsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        formSubset(nums, result, new LinkedList<>(), 0);
        return result;
    }

    private void formSubset(int[] nums, List<List<Integer>> result,
                            LinkedList<Integer> subset, int i) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        System.out.println("After adding :" + subset + " i+1 is: " + (i + 1));
        formSubset(nums, result, subset, i + 1);

        subset.pollLast();
        System.out.println("After polling :" + subset + " i+1 is: " + (i + 1));
        formSubset(nums, result, subset, i + 1);
    }

    public static void main(String[] args) {
        FormSubsets fs = new FormSubsets();
        System.out.println(fs.subsets(new int[]{1, 2, 3}));
    }
}
