package com.company.weekly_contest;

public class Q6055TimeConverter {

    //Minimum Number of Operations to Convert Time
    public static int convertTime(String current, String correct) {
        int[] tokens = {60, 15, 5, 1};
        String[] currentTime = current.split(":");
        String[] correctTime = correct.split(":");
        int currentMinutes = Integer.parseInt(currentTime[0])*60 + Integer.parseInt(currentTime[1]);
        int correctMinutes = Integer.parseInt(correctTime[0])*60 + Integer.parseInt(correctTime[1]);
        int diff = correctMinutes - currentMinutes;

        int minStep = 0;
        int currentPosition = 0;
        while (diff > 0) {
            int now = diff - tokens[currentPosition];
            if (now >= 0) {
                minStep++;
                diff = now;
            } else {
                currentPosition++;
            }
        }
        return minStep;
    }


}
