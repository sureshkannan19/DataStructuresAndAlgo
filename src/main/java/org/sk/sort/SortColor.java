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

    public static void main(String[] args) {
        SortColor s = new SortColor();
        s.sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }
}
