package org.sk.dp;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length > 1) return false;

        int goal = nums.length - 1;
        for (int i = goal; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.canJump(new int[]{4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0}));
        System.out.println(jg.canJump(new int[]{1, 1, 2, 2, 0, 1, 1}));
        System.out.println(jg.canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
        System.out.println(jg.canJump(new int[]{1, 1, 0, 1}));
        System.out.println(jg.canJump(new int[]{1, 2}));
        System.out.println(jg.canJump(new int[]{2, 0, 0}));
        System.out.println(jg.canJump(new int[]{0}));
        System.out.println(jg.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jg.canJump(new int[]{2, 5, 0, 0}));
    }
}

