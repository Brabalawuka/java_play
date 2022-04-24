package com.company;

import leetcode.weekly_contest.Q2243DigitalSum;
import leetcode.weekly_contest.Q2244MinimumRounds;
import leetcode.weekly_contest.Q2246LongestPath;
import leetcode.weekly_contest.Q6039MaxProAftKInc;

public class Main {

    public static void main(String[] args) {
//        var str = "jajaj";
//        var sub = str.substring(5);
//        System.out.println(sub.length());
//        System.out.println(sub);
//
//
//        System.out.println(LargestNumber6037.largestInteger(247));
//
//        int result = TimeConverter6055.convertTime("02:30", "04:35");
//
//
//        write your code here
//        System.out.println(MinimiseResult6038.minimizeResult("12+34"));
//        int[] newArr = {9, 7, 8};
//        System.out.println(Q6039MaxProAftKInc.maximumProduct(newArr, 9));
//        var minimumRounds = new Q2244MinimumRounds();
//        System.out.println(minimumRounds.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        var longestPath = new Q2246LongestPath();
        var result = longestPath.longestPath(new int[]{-1,0,0,1,1,2}, "abacbe");
        System.out.println(result);

    }
}
