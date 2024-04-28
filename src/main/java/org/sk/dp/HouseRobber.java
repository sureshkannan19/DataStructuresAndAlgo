package org.sk.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]); // the maximum robber could steal, is stored at each index
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(new int[]{2, 1, 1, 2}));
        System.out.println(hr.rob(new int[]{1, 2, 3, 1}));
        System.out.println(hr.rob(new int[]{2, 7, 9, 3, 1}));
    }
}

