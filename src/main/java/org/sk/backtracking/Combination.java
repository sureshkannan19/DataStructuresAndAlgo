package org.sk.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combine(n, k, new ArrayList<>(), 1);
        return result;
    }

    private void combine(int end, int expectedKSize, ArrayList<Integer> list, int start) {
        if (expectedKSize == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= end - expectedKSize + 1; i++) {
            list.add(i);
            combine(end, expectedKSize - 1, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination cs = new Combination();
        System.out.println(cs.combine(4, 2));
    }

}
