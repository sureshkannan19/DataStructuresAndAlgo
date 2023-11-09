package org.sk.slidingwindow;

public class MaximumVowelInWindow {
    static int[] vowels = new int[26];

    static {
        vowels['a' - 97] = vowels['e' - 97] = vowels['i' - 97] = vowels['o' - 97] = vowels['u' - 97] = 1;
    }

    public int maxVowels(String s, int k) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels[(s.charAt(i)) - 97] == 1) {
                count++;
            }
            if (i + 1 >= k) {
                maxCount = Math.max(count, maxCount);
                if (maxCount == k) {
                    return maxCount;
                }
                if (vowels[(s.charAt(i + 1 - k)) - 97] == 1) {
                    count--;
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        MaximumVowelInWindow mv = new MaximumVowelInWindow();
        System.out.println(mv.maxVowels("leetcode", 3));
    }
}
