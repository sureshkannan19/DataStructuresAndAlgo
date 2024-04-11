package org.sk.dp;

public class ClimbStairs {

    public int climbStairs(int n) {
        // return climbStairs(0, n);
        if (n == 1 || n == 2) {
            return n;
        }
        int current = 0;
        int prev2 = 2;
        int prev1 = 1;
        for (int i = 3; i <= n; i++) {
            current = prev2 + prev1;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    public int climbStairs1(int n) {
        return climbStairs(0, n);
    }

    private int climbStairs(int stepSize, int top) {
        if (stepSize == top) {
            return 1;
        } else if (stepSize > top) {
            return 0;
        }
        return climbStairs(stepSize + 1, top) + climbStairs(stepSize + 2, top);
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        long start = System.currentTimeMillis();
        System.out.println(cs.climbStairs(44));
        long end = System.currentTimeMillis();
        System.out.println("Time taken to complete iterative approach : " + (end - start));

        start = System.currentTimeMillis();
        System.out.println(cs.climbStairs1(44));
        end = System.currentTimeMillis();
        System.out.println("Time taken to complete recursive approach : " + (end - start));

//        Results:
//        1134903170
//        Time taken to complete iterative approach : 0
//        1134903170
//        Time taken to complete recursive approach : 6752
    }
}
