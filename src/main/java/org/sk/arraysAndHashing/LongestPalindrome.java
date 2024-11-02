package org.sk.arraysAndHashing;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        // Just need to find all even num count and max odd count
        char[] countMap = new char[128];
        for(char c: s.toCharArray()) {
            countMap[c]++;
        }
        int oddCount = 0;
        for(char c: countMap) {
            if(c  % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount > 0 ? s.length() - oddCount  + 1 : s.length();
    }
    public static void main(String[] args) {

    }
}
