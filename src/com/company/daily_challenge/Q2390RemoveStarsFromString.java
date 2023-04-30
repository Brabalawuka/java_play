package com.company.daily_challenge;

import com.sun.source.tree.Tree;

import java.util.TreeMap;

public class Q2390RemoveStarsFromString {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder(s);
        var start = 0;
        while (start < builder.length()){
            if (builder.charAt(start) == '*'){
                builder.deleteCharAt(start);
                if (start > 0) {
                    start = start - 1;
                    builder.deleteCharAt(start);
                }
                continue;
            }
            start++;
        }
        return builder.toString();
    }

    // Try using stack or reverser travesal
    public String removeStarsStack(String s) {
        return "";
    }



}
