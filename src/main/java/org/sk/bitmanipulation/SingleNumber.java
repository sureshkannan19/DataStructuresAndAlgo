package org.sk.bitmanipulation;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operator returns zero if two numbers are same
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{ 1, 2, 1, 2}));
        System.out.println(singleNumber(new int[]{ 4, 1, 2, 1, 2}));
    }
}
