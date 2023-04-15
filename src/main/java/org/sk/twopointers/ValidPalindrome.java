package org.sk.twopointers;

public class ValidPalindrome {

	private static final char[] charMap = new char[256];

	static {
		for (int i = 0; i < 10; i++) {
			charMap[i + '0'] = (char) (1 + i);
		}
		for (int i = 0; i < 26; i++) {
			charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);
		}
	}

	public boolean isPalindrome(String s) {
		char[] input = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		char cS, cE;
		while (start < end) {
			cS = charMap[input[start]];
			cE = charMap[input[end]];
			if (cS != 0 && cE != 0) {
				if (cS != cE) {
					return false;
				}
				start++;
				end--;
			} else {
				if (cS == 0)
					start++;
				if (cE == 0)
					end--;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome("race a car"));
		System.out.println(vp.isPalindrome(" "));
	}
}