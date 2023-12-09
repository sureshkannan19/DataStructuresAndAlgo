package org.sk.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return result;
    }

    private void permute(int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int num : nums) {
                temp.add(num);
            }
            result.add(temp);
        } else {
            for (int cur = start; cur < nums.length; cur++) {
                swap(cur, start, nums, "Before");
                permute(nums, start + 1);
                swap(cur, start, nums, "After");
            }
        }
    }

    private void swap(int cur, int start, int[] nums, String state) {
        if (cur == start) return;
        int temp = nums[cur];
        nums[cur] = nums[start];
        nums[start] = temp;
        System.out.println(state + " Cur value : " + cur + " Start value : " + start + " Nums: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println(p.permute(new int[]{1, 2, 3}));
    }
}
