package com.company;

import com.company.weekly_contest.*;

import java.sql.Timestamp;
import java.util.*;

public class Main {

    public static void main(String[] args) {
//        var list = new ArrayList<>(List.of(new Integer[]{1, 2, 3, 4, 5}));
//
//
//        var a = binarySearchBigger(list, 6);
//        list.set(a, 6);
//        System.out.println(Arrays.toString(list.stream().toArray()));
        Q2327PeopleAwareOfSecret.peopleAwareOfSecret(6,2,4);


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
