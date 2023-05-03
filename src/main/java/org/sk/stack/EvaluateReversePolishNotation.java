package org.sk.stack;

import java.util.LinkedList;

public class EvaluateReversePolishNotation {

	public int evalRPN(String[] tokens) {
		LinkedList<Integer> tokensList = new LinkedList<>();
		for (int i = 0; i < tokens.length; i++) {
			switch (tokens[i]) {
			case "/":
				int last = tokensList.poll();
				int prevLast = tokensList.poll();
				tokensList.push(prevLast / last);
				break;
			case "*":
				tokensList.push(tokensList.poll() * tokensList.poll());
				break;
			case "+":
				tokensList.push(tokensList.poll() + tokensList.poll());
				break;
			case "-":
				last = tokensList.poll();
				prevLast = tokensList.poll();
				tokensList.push(prevLast - last);
				break;
			default:
				tokensList.push(Integer.valueOf(tokens[i]));
				break;
			}
		}
		return tokensList.peek();
	}

	public static void main(String[] args) {
		EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();
		System.out.println(erpn.evalRPN(new String[] { "2", "1", "+", "3", "*" }));
		System.out.println(erpn.evalRPN(new String[] { "4", "13", "5", "/", "+" }));
		System.out.println(erpn.evalRPN(new String[] { "4", "3", "-" }));
	}

}