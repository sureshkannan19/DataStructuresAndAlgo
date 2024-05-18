package org.sk.arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();

        // for(int i = 0; i < nums.length; i++) {
        //     while(nums[i] != i + 1) {
        //         int temp = nums[nums[i] - 1];
        //         if(temp == nums[i]) break;
        //         nums[nums[i] - 1] = nums[i];
        //         nums[i] = temp;
        //     }
        // }

        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] != i + 1) {
        //        duplicates.add(nums[i]);
        //     }
        // }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            int idx = num - 1;
            if (nums[idx] < 0)
                duplicates.add(num);
            nums[idx] *= -1; // visited
        }

        return duplicates;
    }

    public static void main(String[] args) {
        FindDuplicatesInArray fdi = new FindDuplicatesInArray();
        System.out.println(fdi.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
        System.out.println(fdi.findDuplicates(new int[] {1, 1, 2}));
        System.out.println(fdi.findDuplicates(new int[] {1}));
    }
}
