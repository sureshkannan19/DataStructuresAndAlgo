package org.sk.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> weightedStones = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            weightedStones.add(stone);
        }

        while (weightedStones.size() > 1) {
            int x = weightedStones.poll();
            int y = weightedStones.poll();
            if (x != y) {
                weightedStones.add(x - y);
            }
        }
        return !weightedStones.isEmpty() ? weightedStones.poll() : 0;
    }

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{1}));
        System.out.println(lastStoneWeight(new int[]{2, 2}));
    }
}
