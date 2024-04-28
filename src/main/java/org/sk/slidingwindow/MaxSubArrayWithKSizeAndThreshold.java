package org.sk.slidingwindow;

public class MaxSubArrayWithKSizeAndThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = k;

        int validArraysCount = 0;
        int temp = 0;
        while (right <= arr.length) {
            while (left < right) {
                temp += arr[left];
                left++;
            }
            if (temp / k >= threshold) {
                validArraysCount++;
            }
            right++;
            temp -= arr[left - k];
        }
        return validArraysCount;
    }

    public static void main(String[] args) {
        MaxSubArrayWithKSizeAndThreshold ms = new MaxSubArrayWithKSizeAndThreshold();
        System.out.println(ms.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }
}
