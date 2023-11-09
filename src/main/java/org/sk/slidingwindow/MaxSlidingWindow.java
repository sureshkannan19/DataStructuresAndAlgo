package org.sk.slidingwindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length + 1 - k];
        Deque<Integer> deque = new LinkedList<>();
        int resultInd = 0;
        deque.addFirst(nums[0]);
        for (int right = 1; right < nums.length; right++) {
            // Monotonic decreasing queue -- > Store only elements that are smaller than current element
            while (!deque.isEmpty() && deque.getFirst() < nums[right]) { // fetch first element
                deque.removeFirst(); // remove first most element, since it is less than number about to be stored
            }
            deque.addFirst(nums[right]);

            if (right + 1 >= k) {
                result[resultInd] = deque.getLast(); // fetch last element where the max element of current window size is stored
                if (deque.getLast() == nums[resultInd++]) { // Remove the element from deque that is not part of the window
                    deque.removeLast();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow msw = new MaxSlidingWindow();
        System.out.println(Arrays.toString(msw.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(msw.maxSlidingWindow(new int[]{7, 2, 4}, 2)));

    }
}
