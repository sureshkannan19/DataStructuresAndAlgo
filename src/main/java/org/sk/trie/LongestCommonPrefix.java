package org.sk.trie;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        lcp.longestCommonPrefix(new String[] {"flower", "flow", "flick"}); // fl
        lcp.longestCommonPrefix(new String[] {"ab", "a"}); // a
    }
    public String longestCommonPrefix(String[] strs) {
        int maxCommon = 0;
        for (int col = 0; col < strs[0].length(); col++) {
            char c = strs[0].charAt(col);
            int count = 1;
            for (int i = 1; i < strs.length && col < strs[i].length(); i++) {
                if (strs[i].charAt(col) != c) {
                    break;
                }
                count++;
            }
            if (count != strs.length) {
                break;
            }
            maxCommon++;
        }
        return maxCommon > 0 ? strs[0].substring(0, maxCommon) : "";
    }
}
