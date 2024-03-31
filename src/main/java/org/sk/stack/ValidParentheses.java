package org.sk.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {

	static Map<Character, Character> parenthesesMap = new HashMap<>(4, 1f);
	static {
		parenthesesMap.put('}', '{');
		parenthesesMap.put(')', '(');
		parenthesesMap.put(']', '[');
	}

	public boolean isValid(String s) {
		LinkedList<Character> parentheses = new LinkedList<>();
		for (char c : s.toCharArray()) {
			Character open = parenthesesMap.get(c);
			if (open != null) {
				if (!parentheses.isEmpty() && parentheses.peek().equals(open)) {
					parentheses.pop();
				} else {
					return false;
				}
			} else {
				parentheses.push(c);
			}
		}
		return parentheses.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("()"));
		System.out.println(vp.isValid("({})[]"));
		System.out.println(vp.isValid("({}){"));
	}
}

