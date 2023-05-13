package org.sk.slidingwindow;

public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 1 || s.length() == 0) {
			return s.length();
		}
		int[] alphabets = new int[128];
		int maxStreak = 0;

		int left = 0;
		int right = left + 1;
		alphabets[s.charAt(left)]++;
		while (left <= right && (left < s.length() && right < s.length())) {
			if (alphabets[s.charAt(right)] != 0) {
				left = resetWindowAndReturnNewWindowStartIndex(s, alphabets, right, left, s.charAt(right));
			}
			alphabets[s.charAt(right)]++;
			right++;
			maxStreak = Math.max(maxStreak, (right - left));
		}
		return maxStreak;
	}

	private int resetWindowAndReturnNewWindowStartIndex(String s, int[] alphabets, int right, int left, char popTillChar) {
		for (int i = left; i < right; i++) {
			if (s.charAt(i) != popTillChar) {
				alphabets[s.charAt(i)]--;
				continue;
			}
			alphabets[s.charAt(i)]--;
			return i + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstring lols = new LengthOfLongestSubstring();
		System.out.println(lols.lengthOfLongestSubstring("abcabcbb")); // 3
		System.out.println(lols.lengthOfLongestSubstring("bbbbb")); // 1
		System.out.println(lols.lengthOfLongestSubstring("pwwkew")); // 3
		System.out.println(lols.lengthOfLongestSubstring("aab")); // 2
		System.out.println(lols.lengthOfLongestSubstring("dvdf"));// 3
		System.out.println(lols.lengthOfLongestSubstring("tmmzuxt")); // 4

	}
}
