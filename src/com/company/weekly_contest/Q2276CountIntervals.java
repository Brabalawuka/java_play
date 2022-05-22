package com.company.weekly_contest;

import java.util.*;

public class Q2276CountIntervals {

    public ArrayList<Integer> starts;
    public ArrayList<Integer> ends;

    public Q2276CountIntervals() {
        starts = new ArrayList<Integer>();
        ends = new ArrayList<>();
    }

    public void add(int left, int right) {
        var leftposition = binarySearchSmaller(starts, left);
        var righposition = binarySearchBigger(ends, right);
        var curLeftStart = starts.get(leftposition);
        var curLeftEnd = ends.get(leftposition);

        var curRightStart = starts.get(righposition);
        var curRightEnd = ends.get(righposition);

        var isRightBigger = curRightStart > right + 1;
        var isLeftSmaller = curLeftEnd < left - 1;

        if (isLeftSmaller) {

        }






    }

    public int count() {
        return 1;



    }

    static int binarySearchSmaller(List<Integer> arr, int x) {
        int left = 0, right = arr.size() - 1;

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr.get(mid) > x)
                right = mid - 1;


            // If x greater, ignore left half
            if (arr.get(mid) <= x){
                ans = mid;
                left = mid + 1;
            }



        }

        // if we reach here, then element was
        // not present
        return ans;
    }

    static int binarySearchBigger(List<Integer> arr, int x) {
        int left = 0, right = arr.size() - 1;

        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if x is present at mid
            if (arr.get(mid) >= x)

                right = mid - 1;


            // If x greater, ignore left half
            if (arr.get(mid) < x){
                ans = mid+1;
                left = mid + 1;
            }

        }
        // if we reach here, then element was
        // not present
        return ans;
    }


}
