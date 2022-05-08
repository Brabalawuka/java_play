package com.company.weekly_contest;

import java.util.HashMap;

public class Q2244MinimumRounds {

    public int minimumRounds(int[] tasks) {
        var result = 0;
        var taskMap = new HashMap<Integer, Integer>();
        for (int task : tasks) {
            int count = taskMap.getOrDefault(task, 0);
            taskMap.put(task, ++count);
        }

        for (var entrySet : taskMap.entrySet()){
            if (entrySet.getValue() == 1){
                result = -1;
                return result;
            }
            var min = entrySet.getValue() / 3;
            var rest = entrySet.getValue() % 3;
            if (rest == 0){
                result += min;
            } else {
                result += min+1;
            }
        }

        return result;


    }
}
