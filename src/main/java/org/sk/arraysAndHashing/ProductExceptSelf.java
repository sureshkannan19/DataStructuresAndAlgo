package org.sk.arraysAndHashing;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                product *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                nums[i] = nums[i] != 0 ? 0 : product;
            } else if (zeroCount > 1) {
                nums[i] = 0;
            } else {
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

    public int[] productExceptSelfViaPrefixAndSuffix(int[] nums) {
        int[] ans = new int[nums.length];
        int a = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = a; // 1 1 2 6
            a *= nums[i];
        }
        System.out.println("*****************************");
        a = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            ans[j] *= a; // 6 // 8 // 12 // 24
            a *= nums[j];  //  4 // 12 // 24 // 24
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductExceptSelf pes = new ProductExceptSelf();
        System.out.println(Arrays.toString(pes.productExceptSelfViaPrefixAndSuffix(new int[]{1, 2, 3, 4})));
        // 1 2 3 4

        //  1  1  2 6
        // 24 12  8 6

    }
}