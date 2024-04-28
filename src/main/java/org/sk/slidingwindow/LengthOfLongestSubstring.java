package org.sk.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // 1. initiate and populate lastOccurrence array with -1
        // 2. store the occurrence index of each char in the lastOccurrence array
        // 3. check if lastOccurrence array has >-1, which means repeated string occurred
        // 4. shift the start position to lastOccurred Index + 1
        // 5. end position is current index, difference between start and end is maxLength
        int n = s.length();
        if (n <= 1) {
            return n;
        }

        int[] lastOccurrence = new int[128];
        Arrays.fill(lastOccurrence, -1);

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            int lastIndex = lastOccurrence[c];
            if (lastIndex >= start) {
                start = lastIndex + 1;
            }
            lastOccurrence[c] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstring1(String s) {
        int maxSubstrLen = 0;

        int left = 0;
        int right = 0;

        Map<Character, Integer> lastOccurenceMap = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(left);
            Integer index = lastOccurenceMap.get(c);
            if (index != null && index >= left) {
                left = index + 1;
            }
            lastOccurenceMap.put(c, right);
            maxSubstrLen = Math.max(maxSubstrLen, right - left + 1);
            right++;
        }
        return maxSubstrLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
        System.out.println(lols.lengthOfLongestSubstring1("abcabcbb")); // 3
        System.out.println(lols.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lols.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lols.lengthOfLongestSubstring("aab")); // 2
        System.out.println(lols.lengthOfLongestSubstring("dvdf"));// 3
        System.out.println(lols.lengthOfLongestSubstring("tmmzuxt")); // 5

    }
}
