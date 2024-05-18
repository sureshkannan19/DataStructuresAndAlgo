package org.sk.prefixSum;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            rightSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex fpv = new FindPivotIndex();
        System.out.println(fpv.pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println(fpv.pivotIndex(new int[] {1,2,3}));
        System.out.println(fpv.pivotIndex(new int[] {2,1,-1}));
    }

}
