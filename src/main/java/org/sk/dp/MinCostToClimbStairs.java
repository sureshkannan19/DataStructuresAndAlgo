package org.sk.dp;

public class MinCostToClimbStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }

    public static void main(String[] args) {
        MinCostToClimbStairs m = new MinCostToClimbStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10, 15, 20})); // 15
        System.out.println(m.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6

        System.out.println(m.minCostClimbingStairs1(new int[]{10, 15, 20})); // 15
        System.out.println(m.minCostClimbingStairs1(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    }
}
