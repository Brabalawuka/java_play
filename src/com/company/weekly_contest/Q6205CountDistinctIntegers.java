package com.company.weekly_contest;

import java.util.HashMap;

public class Q6205CountDistinctIntegers {

    public int countDistinctIntegers(int[] nums) {

        var uniqueResultMap = new HashMap<String, Boolean>();

        for (int num : nums) {

            var numStr = String.valueOf(num);
            uniqueResultMap.put(numStr, true);

            var sb = new StringBuilder(numStr).reverse();
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            var revStr = sb.toString();
            uniqueResultMap.put(revStr, true);

        }

        return uniqueResultMap.size();

    }
}
