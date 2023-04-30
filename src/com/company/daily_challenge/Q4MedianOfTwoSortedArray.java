package com.company.daily_challenge;

public class Q4MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength == 0) {
            return 0;

        }
        if (totalLength == 1) {
            return nums1.length == 0 ? nums2[0] : nums1[0];
        }

        // normal length
        boolean exactMedian = totalLength % 2 != 0;

        // if length = 16 median is  8 and 9 --> index is 7 and 8;
        // if length == 15 median is 8  --> index is 7;
        int medianPosition = totalLength / 2;

        // current index of the two array
        int curIndex1 = 0;
        int curIndex2 = 0;
        int curTotalIndex = 0;


        // record downs the number themselved
        int currentNumber = 0;
        int prev = 0;

        // merge iteration
        while (curIndex1 < nums1.length && curIndex2 < nums2.length && curTotalIndex <= medianPosition){
            prev = currentNumber;
            if (nums1[curIndex1] < nums2[curIndex2]) {
                currentNumber = nums1[curIndex1];
                curIndex1++;
            } else {
                currentNumber = nums2[curIndex2];
                curIndex2++;
            }
            curTotalIndex++;
        }

        while (curIndex1 < nums1.length  && curTotalIndex <= medianPosition){
            prev = currentNumber;
            currentNumber = nums1[curIndex1];
            curIndex1++;
            curTotalIndex++;
        }

        while (curIndex2 < nums2.length && curTotalIndex <= medianPosition){
            prev = currentNumber;
            currentNumber = nums2[curIndex2];
            curIndex2++;
            curTotalIndex++;
        }

        // calculate median
        if (exactMedian) {
            return currentNumber;
        } else {
            return (double) (prev + currentNumber) / 2;
        }


    }

}
