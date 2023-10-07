package org.sk.arraysAndHashing;

public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] ac = new int[128];
		for (int i = 0; i < s.length(); i++) {
			ac[(int) s.charAt(i)]++;
			ac[(int) t.charAt(i)]--;
		}

        for (int j : ac) {
            if (j != 0) {
                return false;
            }
        }

		return true;
	}

	public static void main(String[] args) {
		IsAnagram ia = new IsAnagram();
		System.out.println(ia.isAnagram("SK", "KS"));
		System.out.println(ia.isAnagram("anagram", "nagaram"));
	}
}
