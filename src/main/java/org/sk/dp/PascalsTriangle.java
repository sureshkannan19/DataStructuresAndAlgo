package org.sk.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>(numRows);
		if (numRows >= 1) {
			result.add(Arrays.asList(1));
		}
		if (numRows >= 2) {
			result.add(Arrays.asList(1, 1));
		}
		if (numRows > 2) {
			for (int i = 3; i <= numRows; i++) {
//				System.out.println("Processing row: " + i);
				List<Integer> prev = result.get(i - 2);
				List<Integer> current = IntStream.of(new int[i]).boxed().collect(Collectors.toList());
				current.set(0, 1); // set first
				current.set(i - 1, 1); // set last
				int left = 1;
				int right = i - 2;
				while (left <= right) { // two pointer
					int temp = prev.get(left) + prev.get(left - 1);
					current.set(left, temp);
					current.set(right, temp);
					left++;
					right--;
				}
				result.add(current);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		System.out.println(pt.generate(5));

	}
}
