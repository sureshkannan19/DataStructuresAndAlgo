package org.sk.slidingwindow;

public class LongestRepeatingCharacter {

	public int characterReplacement(String s, int k) {
		// 1. increment the count of char on each iteration,
		// 2. initialize charCountMap, maxCharacterCount and maxCount
		// 3. if the difference of maxCharacterCount and  (right- left + 1) is greater than the given threshold 'k'
		// 4. then decrement the charCountMap and increment the left position for new window
		int maxCount = 0;
		int left = 0;
		int right = 0;
		int[] charCount = new int[26];

		int maxCharCount = 0;

		while (right < s.length()) {
			charCount[s.charAt(right) - 'A']++;
			maxCharCount = Math.max(maxCharCount, charCount[s.charAt(right) - 'A']);

			if (((right - left + 1) - maxCharCount) > k) {
				charCount[s.charAt(left) - 'A']--;
				left++;
			}

			maxCount = Math.max(maxCount, right - left + 1);
			right++;
		}

		return maxCount;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacter pis = new LongestRepeatingCharacter();
		System.out.println(pis.characterReplacement("ABAB", 2));
		System.out.println(pis.characterReplacement("AABABBA", 1));
		System.out.println(pis.characterReplacement("ABAA", 0));
		System.out.println(pis.characterReplacement("SDSSMESS", 2));
		System.out.println(pis.characterReplacement(
				"IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR",
				2));
	}

}
