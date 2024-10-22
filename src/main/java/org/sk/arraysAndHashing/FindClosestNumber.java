package org.sk.arraysAndHashing;

public class FindClosestNumber {
    public int findClosestNumber(int[] nums) {
        int minDistance = Math.abs(nums[0]);
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int distance = Math.abs(nums[i]);
            if(distance < minDistance) {
                result = nums[i];
                minDistance = distance;
            } else if(distance == minDistance) {
                result = Math.max(nums[i], result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindClosestNumber fcn = new FindClosestNumber();
        System.out.println(fcn.findClosestNumber(new int[] {-4, -2, 1, 4, 8}));
        System.out.println(fcn.findClosestNumber(new int[] {2, -1, 1}));
        System.out.println(fcn.findClosestNumber(new int[] {2, 1, -1}));
    }
}
