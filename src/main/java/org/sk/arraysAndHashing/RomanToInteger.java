package org.sk.arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	static Map<Character, Integer> romanMap = new HashMap<>();

	static {
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
	}

	public int romanToInt(String s) {
		int total = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			total += romanMap.get(s.charAt(i));
			if ((i - 1 >= 0 && s.charAt(i - 1) == 'I') && (s.charAt(i) == 'V' || s.charAt(i) == 'X')
					|| (i - 1 >= 0 && s.charAt(i - 1) == 'X') && (s.charAt(i) == 'C' || s.charAt(i) == 'L')
					|| (i - 1 >= 0 && s.charAt(i - 1) == 'C') && (s.charAt(i) == 'D' || s.charAt(i) == 'M')) {
				total -= romanMap.get(s.charAt(--i));
			}
		}
		return total;
	}

	public static void main(String[] args) {
		RomanToInteger ri = new RomanToInteger();
		System.out.println(ri.romanToInt("IV"));
		System.out.println(ri.romanToInt("V"));
		System.out.println(ri.romanToInt("III"));
		System.out.println(ri.romanToInt("LVIII"));
		System.out.println(ri.romanToInt("MCMXCIV"));
	}

}
