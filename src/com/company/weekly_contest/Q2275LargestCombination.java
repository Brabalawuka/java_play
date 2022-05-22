package com.company.weekly_contest;

public class Q2275LargestCombination {

    public static int largestCombination(int[] candidates) {
        var results = new int[32];
        for (int candidate : candidates) {
            var biStr = Integer.toBinaryString(candidate);
            var last = biStr.length() - 1;
            for (int i = 0; i <= last; i++) {
                var isOne = biStr.charAt(last - i) == '1';
                if (isOne){
                    results[i] += 1;
                }
            }
        }
        var max = 0;
        for (int result : results) {
            if (result >= max){
                max = result;
            }
        }
        return max;


    }
}
