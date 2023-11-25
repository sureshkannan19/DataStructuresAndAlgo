package org.sk.linkedlist;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

/*
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
			System.out.println("Slow : " + slow + " Fast : " + fast);
        } while (slow != fast);

        int slow2 = 0;
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
			System.out.println("Slow2 : " + slow2 + " Slow : " + slow);
        }
        return slow;
*/

        for (int i = 0; i < nums.length; i++) {
            int curr = Math.abs(nums[i]);
            if (nums[curr - 1] < 0) return curr;
            nums[curr - 1] = -1 * nums[curr - 1];
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        FindDuplicateNumber fdn = new FindDuplicateNumber();
//        System.out.println(fdn.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(fdn.findDuplicate(new int[]{3, 1, 3, 4, 2}));
//        System.out.println(fdn.findDuplicate(new int[]{1, 1, 2}));
//        System.out.println(fdn.findDuplicate(new int[]{1, 1}));
    }

}
