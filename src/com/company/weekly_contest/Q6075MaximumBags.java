package com.company.weekly_contest;

import java.util.ArrayList;
import java.util.Collections;

public class Q6075MaximumBags {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        var full = 0;
        var spaces = new ArrayList<Integer>();
        for (int i = 0; i < capacity.length; i++){
            var space = capacity[i] - rocks[i];
            if (space == 0) {
                full ++;
            } else {
                spaces.add(space);
            }
        }
        Collections.sort(spaces);
        for (int space : spaces){
            additionalRocks = additionalRocks - space;
            if (additionalRocks >= 0){
                full++;
            } else {
                break;
            }
        }
        return full;


    }
}
