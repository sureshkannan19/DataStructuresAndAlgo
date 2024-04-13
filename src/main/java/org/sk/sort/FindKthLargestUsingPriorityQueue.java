package org.sk.sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargestUsingPriorityQueue {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            queue.add(num);
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        FindKthLargestUsingPriorityQueue f = new FindKthLargestUsingPriorityQueue();
        System.out.println(f.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(f.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
