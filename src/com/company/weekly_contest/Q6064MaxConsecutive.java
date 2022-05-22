package com.company.weekly_contest;


import java.util.Arrays;

public class Q6064MaxConsecutive {

//    public int maxConsecutive(int bottom, int top, int[] special) {
//        var length = top - bottom + 1;
//        var floors = new boolean[length];
//        for (int spe: special){
//            floors[spe-bottom] = true;
//        }
//        var max = 0;
//        var cur = 0;
//        for (boolean floor: floors){
//            if (!floor){
//                cur++;
//            } else {
//                if (cur > max){
//                    max = cur;
//                }
//                cur = 0;
//            }
//        }
//        if (cur > max){
//            max = cur;
//        }
//        return max;
//
//
//    }

    public int maxConsecutive(int bottom, int top, int[] special) {

        Arrays.parallelSort(special);
        var max = 0;
        var prev = bottom;

        for (int spec: special){
            if (spec - prev > max) {
                max = spec - prev;
            }
            prev = spec + 1;
        }
        if (top - prev + 1 > max){
            max = top - prev + 1;
        }
        return max;

    }


//    public int maxConsecutive(int bottom, int top, int[] special) {
//        var max = top - bottom + 1;
//        for (int spe: special){
//            if (spe >= bottom && spe <= top){
//                if (spe - bottom > top - spe){
//                    top = bottom - 1;
//                } else {
//
//                }
//            }
//
//            if (bottom > top){
//                return 0;
//            }
//        }
//
//
//        return top - bottom + 1;
//    }
//    public int maxConsecutive(int bottom, int top, int[] special) {
//        return maxConsecutiveSub(bottom, top, special, 0);
//    }

//    public int maxConsecutiveSub(int bottom, int top, int[] special, int cur) {
//        if (cur >= special.length){
//            System.out.println(top - bottom + 1);
//            return top - bottom + 1;
//        }
//
//        if (bottom > top){
//            System.out.println(top - bottom + 1);
//            return 0;
//        }
//
//        if (special[cur] >= bottom && special[cur] <= top){
//            if (special[cur] - bottom > top - special[cur]){
//                System.out.println(top - bottom + 1);
//                return maxConsecutiveSub(bottom, special[cur]-1, special, cur+1);
//            } else if (special[cur] - bottom < top - special[cur]) {
//                System.out.println(top - bottom + 1);
//                return maxConsecutiveSub(special[cur]+1, top, special, cur+1);
//            } else {
//                System.out.println(top - bottom + 1);
//                var left = maxConsecutiveSub(bottom, special[cur]-1, special, cur+1);
//                var right = maxConsecutiveSub(special[cur]+1, top, special, cur+1);
//                return Integer.max(left, right);
//
//            }
//        } else {
//            System.out.println(top - bottom + 1);
//            return maxConsecutiveSub(bottom, top, special, cur+1);
//        }
//
//
//    }
}
