package org.sk.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static int fibonacciViaTabulation(int n) {
        int[] dp = new int[n];
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int fibonacciViaMemoization(int n, Map<Integer, Integer> fibonacci) {
        Integer value = fibonacci.get(n);
        if (value != null) {
            return value;
        }
        fibonacci.put(n, fibonacciViaMemoization(n - 1, fibonacci) + fibonacciViaMemoization(n - 2, fibonacci));
        return fibonacci.get(n);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> fibonacci = new HashMap<>();
        fibonacci.put(0, 0);
        fibonacci.put(1, 1);
        System.out.println(fibonacciViaTabulation(5));
        System.out.println(fibonacciViaMemoization(4, fibonacci));
    }
}
