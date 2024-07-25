package org.sk.iq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Pythagoras {

	public static void main(String[] args) {
		List<Integer> sqrOfInput = IntStream.range(1, 101).boxed().map(num -> num * num).toList();
		List<String> result = new ArrayList<>();
		for (int i = sqrOfInput.size() - 1; i > 1; i--) {
			HashSet<Integer> s = new HashSet<>();
			for (int j = i - 1; j >= 0; j--) {
				int bal = sqrOfInput.get(i) - sqrOfInput.get(j);
				if (s.contains(bal)) {
					result.add((j + 1) + "+" + (int) Math.sqrt(bal) + " = " + (i + 1));
				}
				s.add(sqrOfInput.get(j));
			}
		}
		System.out.println(result);
	}

}
