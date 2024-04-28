package org.sk.dp;

public class MinCostToClimbStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }
        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] = min(cost, i);
        }
        return Math.min(cost[0], cost[1]);
    }
    private int min(int[] cost, int i) {
        if (i + 1 >= cost.length || i + 2 >= cost.length) {
            return cost[i];
        }
        return cost[i] + Math.min(cost[i + 1], cost[i + 2]);
    }

    public static void main(String[] args) {
        MinCostToClimbStairs m = new MinCostToClimbStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(m.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
