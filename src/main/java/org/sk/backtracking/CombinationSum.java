package org.sk.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    int target = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        this.target = target;
        formCombination(result, new LinkedList<>(), candidates, 0, 0);
        return result;
    }

    public void formCombination(List<List<Integer>> result, LinkedList<Integer> subset,
                                int[] candidates, int sum, int i) {
        if (sum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (i >= candidates.length || sum > target) {
            return;
        }

        subset.add(candidates[i]);
        formCombination(result, subset, candidates, sum + candidates[i], i);

        subset.pollLast();
        formCombination(result, subset, candidates, sum, i + 1);
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        System.out.println(cs.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}
