package org.sk.arraysAndHashing;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSeq {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> uniqueElements = new HashSet<>();
        for (int i : nums) {
            uniqueElements.add(i);
        }
        for (int i : nums) {
            if (!uniqueElements.contains(i - 1)) {
                int streak = 1;
                while (uniqueElements.contains(i + 1)) {
                    streak++;
                    i++;
                }
                longest = Math.max(streak, longest);
            }
            if (longest > nums.length / 2) break;
        }
        return longest;
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = 1;
        TreeSet<Integer> uniqueElements = new TreeSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int temp = 1;
        int val = uniqueElements.pollFirst().intValue();
        while (!uniqueElements.isEmpty()) {
            if (uniqueElements.contains(val + 1)) {
                temp++;
            } else {
                max = Math.max(temp, max);
                temp = 1;
            }
            val = uniqueElements.pollFirst().intValue();
            if (max > nums.length / 2) break;
        }
        return Math.max(temp, max);
    }


    public static void main(String[] args) {
        LongestConsecutiveSeq lcq = new LongestConsecutiveSeq();

        // using HashSet
        System.out.println(lcq.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(lcq.longestConsecutive(new int[]{1, 2, 0, 1}));
        System.out.println(lcq.longestConsecutive(new int[]{4, 100, 200, 1, 2, 3}));
        System.out.println(lcq.longestConsecutive(new int[]{0, 1, -1}));
        System.out.println(lcq.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));

        // using TreeSet
        System.out.println(lcq.longestConsecutive1(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(lcq.longestConsecutive1(new int[]{1, 2, 0, 1}));
        System.out.println(lcq.longestConsecutive1(new int[]{4, 100, 200, 1, 2, 3}));
        System.out.println(lcq.longestConsecutive1(new int[]{0, 1, -1}));
        System.out.println(lcq.longestConsecutive1(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}