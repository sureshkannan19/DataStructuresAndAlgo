package org.sk.slidingwindow;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {

//		String result = "";
//		if (t.length() > s.length()) {
//			return result;
//		}
//
//		Map<Character, Integer> needSubstrMap = new HashMap<>();
//		for (char c : t.toCharArray()) {
//			needSubstrMap.compute(c, (k, v) -> v != null ? v + 1 : 1);
//		}
//
//		int left = -1;
//		int right = 0;
//
//		int haveCount = 0;
//		int needCount = needSubstrMap.size();
//		/**
//		 * Track current window char count
//		 */
//		int[] haveSubstrCountMap = new int[128];
//		/**
//		 * hold minimum window left and right values
//		 */
//		int[] res = new int[2];
//		int resLen = Integer.MAX_VALUE;
//
//		while (right < s.length()) {
//			Integer count = needSubstrMap.get(s.charAt(right));
//			if (count != null) {
//				if (left == -1) {
//					left = right;
//				}
//				haveSubstrCountMap[s.charAt(right)]++;
//				if (haveSubstrCountMap[s.charAt(right)] == count) {
//					haveCount++;
//				}
//			}
//			right++;
//			while (haveCount == needCount) {
//				if (resLen > (right - left)) {
//					resLen = right - left;
//					res[0] = left;
//					res[1] = right;
//				}
//				haveSubstrCountMap[s.charAt(left)]--;
//				count = needSubstrMap.get(s.charAt(left));
//				if (count != null && haveSubstrCountMap[s.charAt(left)] < count.intValue()) {
//					haveCount--;
//				}
//				left++;
//			}
//		}
//		return s.substring(res[0], res[1]);

		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
			return new String();
		}
		int[] map = new int[128];
		int count = t.length();
		int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
		for (char c : t.toCharArray()) {
			map[c]++;
		}
		char[] chS = s.toCharArray();
		while (end < chS.length) {
			if (map[chS[end++]]-- > 0) {
				count--;
			}
			while (count == 0) {
				if (end - start < minLen) {
					startIndex = start;
					minLen = end - start;
				}
				if (map[chS[start++]]++ == 0) {
					count++;
				}
			}
		}

		return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
	}

	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("aa", "aa"));
		System.out.println(mws.minWindow("bba", "ab"));
		System.out.println(mws.minWindow("cfabeca", "cae"));
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
	}
}
