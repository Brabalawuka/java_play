package com.company.weekly_contest;

public class Q6074PercentageLetter {

    public int percentageLetter(String s, char letter) {
        var length = s.length();
        var total = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) {
                total++;
            }
        }
        return (int) Math.floor((float) total / (float) length * 100);

    }
}
