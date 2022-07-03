package com.company.weekly_contest;

import java.util.HashMap;

public class Q2281TotalStrength {

    long moduleFactor = 1000000000 + 7;

    static class Result {
        long min;
        long sum;
        public Result(long min, long sum){
            this.min = min;
            this.sum = sum;
        }
    }


    public int totalStrength(int[] strength) {
        long finalResult = 0;
        HashMap<Integer, Result[]> allResults = new HashMap<>();

        var strengthLength = strength.length;

        //Calculate single strength;
        var singleStrengthResults = new Result[strengthLength];
        for (int i = 0; i < strengthLength; i++) {
            //Assign single strength
            var curResult = new Result(strength[i], strength[i]);
            singleStrengthResults[i] = curResult;
            var total = curResult.min * curResult.sum % moduleFactor;
            finalResult = (finalResult + total) % moduleFactor;
            System.out.println("total: " + total);
            System.out.println("final: " + finalResult);
        }
        allResults.put(1, singleStrengthResults);
        System.out.println(finalResult);

        for (int i = 2; i <= strengthLength; i++) {
            //number of combination of the current length
            var maxLengthForCurrent = strengthLength-i+1;
            var strengthResult = new Result[maxLengthForCurrent];
            var preResults = allResults.get(i-1);
            //Get PreResult length

            for (int j = 0; j < maxLengthForCurrent; j++) {
                var singleResultOffSet = (i-1) + j;
                var min = Math.min(preResults[j].min, singleStrengthResults[singleResultOffSet].min);
                var sum = preResults[j].sum + singleStrengthResults[singleResultOffSet].sum;
                var curResult = new Result(min, sum);
                //add to cache
                strengthResult[j] = curResult;
                var total = curResult.min * curResult.sum % moduleFactor;
                finalResult = (finalResult + total) % moduleFactor;
                System.out.println("total: " + total);
                System.out.println("final: " + finalResult);
            }
            allResults.put(i, strengthResult);
        }

        return (int) finalResult;
    }




}
