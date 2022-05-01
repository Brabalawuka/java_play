package leetcode.weekly_contest;

import java.util.HashMap;

public class Q2260MinimumCardPickup {
    public int minimumCardPickup(int[] cards) {
        var mapTracker = new HashMap<Integer, Integer>();
        var firstPointer = 0;
        var secPointer = 0;
        var len = cards.length;
        System.out.println(len);
        var minLength = -1;
        while (secPointer <= len-1) {
            //System.out.println("First:"+ firstPointer+"Sec:"+secPointer);
            var occur = mapTracker.getOrDefault(cards[secPointer], 0);
            if (occur == 0) {
                mapTracker.put(cards[secPointer], occur + 1);
                secPointer++;
            }

            if (occur == 1) {
                mapTracker.put(cards[secPointer], occur + 1);
                while (firstPointer <= secPointer) {
                    mapTracker.put(cards[firstPointer], mapTracker.getOrDefault(cards[firstPointer], 0) - 1);
                    if (cards[firstPointer] == cards[secPointer]) {
                        var curMin = secPointer - firstPointer + 1;
                        if (curMin <= minLength || minLength == -1) {
                            minLength = curMin;
                        }
                        //System.out.println("Curmin:"+ curMin + "Min:" + minLength+"First:"+ firstPointer+"Sec:"+secPointer);
                        secPointer++;
                        firstPointer++;
                        break;
                    } else {
                        firstPointer++;
                    }

                }
            }
            //System.out.println("Occur:"+occur);

        }
        return minLength;


    }
}
