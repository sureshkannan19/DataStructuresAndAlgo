package org.sk.slidingwindow;

public class MinConversion {
    public static int minimumRecolors(String blocks, int k) {

        int blackCount = 0;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
        }
        int minConversion = k - blackCount;
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
            if (blocks.charAt(i - k) == 'B') {
                blackCount--;
            }
            minConversion = Math.min(minConversion, k - blackCount);
            if (minConversion == 0) return 0;
        }
        return minConversion;
    }

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
        System.out.println(minimumRecolors("WWWW", 4));
        System.out.println(minimumRecolors("BWWWBB", 6));
    }
}
