package org.sk.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class IsPermutation {

    public boolean permutation(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            map.compute(array1[i], (k, v) -> v != null ? v + 1 : 1);
        }

        for (int i = 0; i < array2.length; i++) {
            Integer val = map.get(array2[i]);
            if (val == null || val == 0) {
                return false;
            } else {
                map.put(array2[i], val - 1);
            }
        }
        return true;
    }

    public boolean permutation1(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        int sum1 = 0, sum2 = 0;
        int mul1 = 1, mul2 = 1;

        for (int i = 0; i < array2.length; i++) {
            sum1 += array1[i];
            sum2 += array2[i];
            mul1 *= array1[i];
            mul2 *= array2[i];
        }
        return sum1 == sum2 && mul1 == mul2;
    }


    public static void main(String[] args) {
        IsPermutation ip = new IsPermutation();
        System.out.println(ip.permutation(new int[]{1, 2, 3, 4, 5}, new int[]{5, 1, 2, 3, 4}));
        System.out.println(ip.permutation(new int[]{1, 2, 3, 4, 5, 5, 3, 4}, new int[]{5, 5, 3, 3, 1, 2, 3, 4}));
        System.out.println(ip.permutation1(new int[]{1, 2, 3, 4, 5, 5, 3, 4}, new int[]{5, 5, 3, 3, 1, 2, 3, 4}));
    }

}