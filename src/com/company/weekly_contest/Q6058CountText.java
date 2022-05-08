package com.company.weekly_contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q6058CountText {
    public static HashMap<Integer, ArrayList<Integer>> ResultCache = new HashMap<>();

    public int countTexts(String pressedKeys) {
        long result = 1;

        // Start
        var cur = -1;
        var len = 0;

        for (int i = 0; i < pressedKeys.length(); i++) {
            var curInt = Character.getNumericValue(pressedKeys.charAt(i));
            if (curInt == cur) {
                len++;
            } else {
                if (cur != -1) {
                    var preCombi = getCurrentCombi(getMaxFibonacciLength(cur), cur, len) % (1000000000 + 7);
                    result = (result * preCombi) % (1000000000 + 7);
                }
                //Reset
                len = 1;
                cur = curInt;

            }
        }

        var preCombi = getCurrentCombi(getMaxFibonacciLength(cur), cur, len) % (1000000000 + 7);
        result = (result * preCombi) % (1000000000 + 7);
        return (int) result;


    }

    public int getMaxFibonacciLength(int a) {
        if (a == 2 || a == 3 || a == 4 || a == 5 || a == 6 || a == 8) {
            return 3;
        }
        return 4;
    }

    public int getCurrentCombi(int fibonacciLength, int input, int length) {
        var resultCacheList = ResultCache.getOrDefault(input, new ArrayList<Integer>(100001));
        var cacheLength = resultCacheList.size();
        if (cacheLength >= length) {
            return resultCacheList.get(length);
        }
        for (int i = cacheLength; i < length; i++) {
            var sum = 0;
            for (int j = 0; j < fibonacciLength; j++) {
                var index = i - j;
                if (index == 0) {
                    sum += 1;
                    continue;
                }
                if (index < 0) {
                    continue;
                }
                sum = (sum + resultCacheList.get(index - 1)) % (1000000000 + 7) ;
            }
            resultCacheList.add(sum);
        }
        return resultCacheList.get(length-1);
    }

    public int countTextsBest(String s) {
        int dp[] = new int[]{1, 1, 1, 1, 1};
        char[] k = s.toCharArray();
        int n = k.length;
        for (int i = n - 1; i >= 0; --i) {
            dp[i % 5] = 0;
            int max_j = Math.min(n, i + (k[i] == '7' || k[i] == '9' ? 4 : 3));
            for (int j = i; j < max_j && k[i] == k[j]; ++j)
                dp[i % 5] = (dp[i % 5] + dp[(j + 1) % 5]) % 1000000007;
        }
        return dp[0];
    }
}
