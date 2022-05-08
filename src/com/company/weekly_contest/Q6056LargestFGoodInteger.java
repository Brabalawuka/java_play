package com.company.weekly_contest;

import java.util.ArrayList;

public class Q6056LargestFGoodInteger {

    public String largestGoodInteger(String num) {
        var result = -1;
        var curLength = 0;
        var prev = -1;


        for (byte i : num.getBytes()) {
            int cur = Integer.parseInt(Character.toString(i));
            //Compare and Swap
            if (prev == cur){
                curLength++;
            } else {
                prev = cur;
                curLength = 1;
            }

            if (curLength == 3){
                if (prev >= result){
                    result = prev;
                }
            }

        }


        if (result == -1){
            return "";
        }
        return new StringBuilder().append(result).append(result).append(result).toString();

    }
}
