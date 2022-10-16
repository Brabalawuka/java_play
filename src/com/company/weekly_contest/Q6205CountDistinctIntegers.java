package com.company.weekly_contest;

import java.util.HashMap;

public class Q6205CountDistinctIntegers {

    public int findMaxK(int[] nums) {
        var max = -1;
        var tempMap = new HashMap<Integer, Boolean>();
        for (int num : nums) {
            if (tempMap.containsKey(num*-1)) {
                if (Math.abs(num) >= max) {
                    max = Math.abs(num);
                }
            } else {
                tempMap.put(num, true);
            }
        }
        return max;

    }
}
