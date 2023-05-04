package org.sk.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {

	static Map<Character, Character> paranthesesMap = new HashMap<>(4, 1f);
	static {
		paranthesesMap.put('}', '{');
		paranthesesMap.put(')', '(');
		paranthesesMap.put(']', '[');
	}

	public boolean isValid(String s) {
		LinkedList<Character> parantheses = new LinkedList<>();
		for (char c : s.toCharArray()) {
			Character open = paranthesesMap.get(c);
			if (open != null) {
				if (!parantheses.isEmpty() && parantheses.peek().equals(open)) {
					parantheses.pop();
				} else {
					return false;
				}
			} else {
				parantheses.push(c);
			}
		}
		return parantheses.size() == 0;
	}
	
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("()"));
		System.out.println(vp.isValid("({})[]"));
		System.out.println(vp.isValid("({}){"));
	}
}

