package org.sk.bitmanipulation;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int counter = 0;
            int num = i;
            while (num > 0) {
                if (num % 2 != 0) {
                    counter++;
                }
                num /= 2;
            }
            result[i] = counter;
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(5)));
        System.out.println(Arrays.toString(cb.countBits(7)));
        System.out.println(Arrays.toString(cb.countBits(11)));
    }
}
