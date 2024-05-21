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

    static int[][] t;
    public static int longestCommonSubsequenceViaRecursion(String text1, String text2) {
        int m=text1.length(), n=text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        t = new int[m+1][n+1];

        return lcs(t1, t2, m, n);
    }

    private static int lcs(char[] t1, char[] t2, int i, int j){
        if(t[i][j] > 0)
            return t[i][j];

        if(i == 0 || j == 0)
            return 0;

        int val = 0;
        if(t1[i-1] == t2[j-1])
            val = 1 + lcs(t1, t2, i-1, j-1);
        else
            val = Math.max(lcs(t1, t2, i-1, j), lcs(t1, t2, i, j-1));

        t[i][j] = val;
        return val;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequenceViaRecursion("ezupkr", "ubmrapg"));
        System.out.println(longestCommonSubsequenceViaRecursion("abcde", "ace"));
    }

}

