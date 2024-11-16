package org.sk.dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if(nums.length > 1) nums[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.rob(new int[]{2, 1, 1, 2}));
        System.out.println(hr.rob(new int[]{1, 2, 3, 1}));
        System.out.println(hr.rob(new int[]{2, 7, 9, 3, 1}));
    }
}

