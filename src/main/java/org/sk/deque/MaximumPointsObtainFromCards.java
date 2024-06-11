package org.sk.deque;

public class MaximumPointsObtainFromCards {

    public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        maxSum = sum;
        if (k == cardPoints.length) return maxSum;
        int front = k - 1, back = cardPoints.length - 1;
        while (front >= 0) {
            sum -= cardPoints[front];
            sum += cardPoints[back];
            front--;
            back--;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1, 1000, 1}, 1));
        System.out.println(maxScore(new int[]{100, 40, 17, 9, 73, 75}, 3));
        System.out.println(maxScore(new int[]{2, 2, 2}, 2));
        System.out.println(maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }

}
