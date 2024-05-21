package org.sk.dp;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] arr = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }
        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("ezupkr", "ubmrapg"));
    }

}
