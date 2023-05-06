package org.sk.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new LinkedList<>();
		LinkedList<String> stack = new LinkedList<>();
//		backTracking(0, 0, n, result, stack);
		backTracking(result, new StringBuilder(), n, n);
		return result;
	}

	private void backTracking(int open, int close, int n, List<String> result, LinkedList<String> stack) {
		if ((open == close) && (close == n)) {
			String temp = stack.stream().collect(Collectors.joining());
			result.add(temp);
			System.out.println(temp);
			return;
		}
		if (open < n) {
			stack.push(")");
			backTracking(open + 1, close, n, result, stack);
			stack.pop();
		}
		if (close < open) {
			stack.push("(");
			backTracking(open, close + 1, n, result, stack);
			stack.pop();
		}
	}

	private void backTracking(List<String> ans, StringBuilder sb, int left, int right) {
		if (left == 0 && right == 0) {
			ans.add(sb.toString());
//			System.out.println(sb.toString());
			return;
		}
		// int len = sb.length();
		if (left > 0) {
			sb.append("(");
			backTracking(ans, sb, left - 1, right);
			sb.setLength(sb.length() - 1);
		}
		if (right > left) {
			sb.append(")");
			backTracking(ans, sb, left, right - 1);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}

}
