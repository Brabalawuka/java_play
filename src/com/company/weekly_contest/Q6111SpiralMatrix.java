package com.company.weekly_contest;

import com.company.util.ListNode;

public class Q6111SpiralMatrix {

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        var result = new int[m][n];

        var left = 0;
        var right = n - 1;
        var top = 0;
        var btm = m - 1;


        var cur = head;

        while (true){
            //start with top
            if (left > right){
                break;
            }
            for (int i = left; i <= right; i++) {
                result[top][i] = cur.val;
                if (cur.next == null){
                    cur.val = -1;
                    cur.next = cur;
                }
                cur = cur.next;
            }
            top ++;
            System.out.println();

            //then right
            if (top > btm){
                break;
            }
            for (int i = top; i <= btm; i++) {
                result[i][right] = cur.val;
                if (cur.next == null){
                    cur.val = -1;
                    cur.next = cur;
                }
                cur = cur.next;
            }
            right --;

            //then bottom
            if (right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                result[btm][i] = cur.val;
                if (cur.next == null){
                    cur.val = -1;
                    cur.next = cur;
                }
                cur = cur.next;
            }
            btm --;

            //then left
            if (btm < top){
                break;
            }
            for (int i = btm; i >= top; i--) {
                result[i][left] = cur.val;
                if (cur.next == null){
                    cur.val = -1;
                    cur.next = cur;
                }
                cur = cur.next;
            }
            left ++;





        }
        return result;


    }

}



