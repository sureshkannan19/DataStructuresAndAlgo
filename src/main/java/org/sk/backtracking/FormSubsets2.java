package org.sk.backtracking;

import java.util.*;

public class FormSubsets2 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        formSubset2(nums, result, new LinkedList<>(), 0);
        return result;
    }

    private void formSubset2(int[] nums, List<List<Integer>> result,
                             LinkedList<Integer> subset, int ind) {
        result.add(new ArrayList<>(subset));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) {
                System.out.println("Skipped i " + i + " and Ind: " + ind);
                continue;
            }
            subset.add(nums[i]);
            System.out.println("After adding :" + subset + " curr is: " + i + " next is: " + (ind + 1));
            formSubset2(nums, result, subset, i + 1);
            subset.pollLast();
            System.out.println("After polling :" + subset + " curr is: " + i + " next is: " + (ind + 1));
        }
    }

    public static void main(String[] args) {
        FormSubsets2 fs = new FormSubsets2();
        System.out.println(fs.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
