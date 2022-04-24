package leetcode.weekly_contest;

import java.util.PriorityQueue;

public class Q2251FullBloomFlowers {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {

        var events = new PriorityQueue<int[]>((a,b) -> a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]);

        for (int[] flower: flowers){
            events.add(new int[]{flower[0], 0});
            events.add(new int[]{flower[1], 2});
        }

        for (int i = 0; i < persons.length; i++) {
            events.offer(new int[]{persons[i], 1, i});
        }


        var curBloom = 0;
        var result = new int[persons.length];

        while (!events.isEmpty()){
            var cur = events.poll();
            if (cur[1] == 0){
                curBloom++;
            } else if (cur[1] == 1){
                result[cur[2]] = curBloom;
            } else {
                curBloom--;
            }
        }

        return result;


    }


}
