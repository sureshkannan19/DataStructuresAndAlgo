package org.sk.binarysearch;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;

        while (left <= right) {
            int partitionA = (left + right) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : nums2[partitionB - 1];

            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : nums1[partitionA];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                right = partitionA - 1;
            } else {
                left = partitionA + 1;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int i1, i2, i = 0;
        if ((m + n) % 2 != 0) {
            i1 = i2 = (m + n) / 2;
        } else {
            i2 = (m + n) / 2;
            i1 = i2 - 1;
        }
        int[] mergedSortedArray = new int[i2 + 1];
        if (nums1.length == 0) {
            return (nums2[i1] + nums2[i2]) / 2d;
        } else if (nums2.length == 0) {
            return (nums1[i1] + nums1[i2]) / 2d;
        }


        if (nums1[m - 1] <= nums2[0]) {
            int first = 0, second = 0;
            if (i1 < m) {
                first = nums1[i1];
            } else {
                return (nums2[i1 - m] + nums2[i2 - m]) / 2d;
            }
            if (i2 < m) {
                second = nums1[i2];
            } else {
                second = nums2[i2 - m];
            }
            return (first + second) / 2d;
        }

        int left = 0, right = 0;
        while (i < mergedSortedArray.length && i <= i2) {
            if (left < nums1.length && right < nums2.length && nums1[left] <= nums2[right]) {
                mergedSortedArray[i++] = nums1[left++];
            } else if (right < nums2.length) {
                mergedSortedArray[i++] = nums2[right++];
            } else if (left < nums1.length) {
                mergedSortedArray[i++] = nums1[left++];
            }
        }
        return (mergedSortedArray[i1] + mergedSortedArray[i2]) / 2d;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray m = new MedianOfTwoSortedArray();
        System.out.println(m.findMedianSortedArrays(new int[]{2, 3, 4}, new int[]{1}));
        System.out.println(m.findMedianSortedArrays(new int[]{1}, new int[]{2, 3}));
        System.out.println(m.findMedianSortedArrays(new int[]{100001}, new int[]{100000}));
        System.out.println(m.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        System.out.println(m.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(m.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}

