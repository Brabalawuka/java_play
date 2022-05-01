package leetcode.weekly_contest;

import java.util.HashMap;

public class Q2262AppealSum {
    public long appealSum(String s) {
        var len = s.length();
        var letterIndex = new HashMap<Character, Integer>();
        long prevNum = 0;
        long sum = 0;
        for (int i = 0; i < len; i++){
            var curChar = s.charAt(i);
            var curIndex = i+1;
            long curSum = curIndex + prevNum - letterIndex.getOrDefault(s.charAt(i), 0);
            sum += curSum;
            letterIndex.put(s.charAt(i), curIndex);
            prevNum = curSum;
        }
        return sum;

    }
}
