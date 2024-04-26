package org.sk.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSubset {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> subset = new ArrayList<>();
            // Approach 1:
            int ind = 0;
            int n = i;
            while (n > 0) {
                if (n % 2 != 0) {  // Checking ith bit is set or not
                    subset.add(nums[ind]);
                }
                n /= 2;
                ind++;
            }
//            Approach 2:
//            for (int j = 0; j < nums.length; j++) {
//                if ((i & (1 << j)) != 0) { // Checking ith bit is set or not
//                    subset.add(nums[j]);
//                }
//            }
            subsets.add(subset);
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        // two's binary form is :
        // (4)  (3)  (2)  (1)  (0)
        //  0    0    0    0    0
        // number = 2
        // number of times left shift
        System.out.println(2 << 1);  // Left shift the 1 in binary form of 2, one place == 4
        System.out.println(2 << 2);  // Left shift the 1 in binary form of 2, two place == 8
        System.out.println(2 << 3);  // Left shift the 1 in binary form of 2, three place == 16


        System.out.println(5 << 1);  // Left shift the 1 in binary form of 2, one place == 10
        System.out.println(5 << 2);  // Left shift the 1 in binary form of 2, two place == 20
        System.out.println(5 << 3);  // Left shift the 1 in binary form of 2, three place == 40

        int n = 7;
        String binaryString = Integer.toBinaryString(n);
        System.out.println(binaryString);
    }
}
