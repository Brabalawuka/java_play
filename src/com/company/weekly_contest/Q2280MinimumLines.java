package com.company.weekly_contest;

import java.util.Arrays;
import java.util.Comparator;

public class Q2280MinimumLines {
    public int minimumLines(int[][] stockPrices) {

        if (stockPrices.length == 1){
            return 0;
        }

        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));


        var preDiff = new int[]{stockPrices[1][0] - stockPrices[0][0],stockPrices[1][1] - stockPrices[0][1]};
        var sum = 1;

        for (int i = 1; i < stockPrices.length-1; i++) {
            int[] cur = stockPrices[i];
            int[] next = stockPrices[i+1];
            int xDiff = next[0] - cur[0];
            int yDiff = next[1] - cur[1];
            double expectYDiff = (double)xDiff / (double)preDiff[0] * preDiff[1];
            if (expectYDiff != yDiff ){
                sum++;
            }
            System.out.println("pre: " + preDiff[0] + " " + preDiff[1] + " xDiff: " + xDiff +" ydiff: " + yDiff + " expectedDiff: " + expectYDiff);
            preDiff[0] = xDiff;
            preDiff[1] = yDiff;
        }

        return sum;

    }
}
