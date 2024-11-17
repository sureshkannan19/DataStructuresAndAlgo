package org.sk.amazon;

import java.util.Arrays;
import java.util.HashSet;

public class FindFreeOfOutlier {

    public static void main(String[] args) {
        int[] f1 = {4, 5, 3, 1, 2};
        int[] f2 = {2, 1, 3, 4, 5};

        int n = f1.length;
        int[] dp = new int[n];
        int maxLength = 1;

        // Initialize dp array
        // Each element is a subsequence of length 1 by itself
        Arrays.fill(dp, 1);

        // Fill dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if ((f1[i] > f1[j] && f2[i] > f2[j]) || (f1[i] < f1[j] && f2[i] < f2[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        System.out.println(maxLength);
    }
}

