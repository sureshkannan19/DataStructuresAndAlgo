package org.sk.twopointers;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray2 {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return index;
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray2 rd = new RemoveDuplicatesInSortedArray2();
//        System.out.println(rd.removeDuplicates(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(rd.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3}));
        System.out.println(rd.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
