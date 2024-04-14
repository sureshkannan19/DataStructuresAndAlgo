package org.sk.sort;

import java.util.Arrays;

public class SortColor {
    public void sortColors(int[] nums) {
        int[] colors = {0, 0, 0};
        for (int n : nums) {
            colors[n]++;
        }

        int index = 0;
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] > 0) {
                nums[index++] = i;
                colors[i]--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void sortColorsViaTwoPass(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                i--;
            }
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        SortColor s = new SortColor();
        s.sortColorsViaTwoPass(new int[]{2, 0, 2, 1, 1, 0});
        s.sortColorsViaTwoPass(new int[]{1, 2, 0});

        s.sortColors(new int[]{2, 0, 2, 1, 1, 0});
        s.sortColors(new int[]{1, 2, 0});
    }
}
