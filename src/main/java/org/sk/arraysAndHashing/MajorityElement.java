package org.sk.arraysAndHashing;

public class MajorityElement {

    /**
     * Works only if the input has majority elements
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int majorityElement = 0;
        int count = 0;
        for(int num: nums) {
            if(count == 0) {
                majorityElement = num;
            }
            if(majorityElement == num) count++;
            else count--;
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] { 1, 1, 2, 2, 1}));
//        System.out.println(majorityElement(new int[] { 1, 1, 2, 2, 0}));  -- wont work
    }
}
