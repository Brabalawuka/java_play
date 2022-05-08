package com.company.weekly_contest;

import com.company.util.TreeNode;

public class Q6057AverageOfSubTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public static int EqualNum = 0;
    public int averageOfSubtree(TreeNode root) {
        var a = findSumAndNum(root);
        var result = EqualNum;
        EqualNum = 0;
        return result;

    }
    //[num, sum]
    public int[] findSumAndNum(TreeNode node) {
        if (node == null){
            return new int[]{0,0};
        }
        int[] left = findSumAndNum(node.left);
        int[] right = findSumAndNum(node.right);

        var numTotal = left[0] + right[0] + 1;
        var sum = left[1] + right[1] + node.val;
        var average = sum / numTotal;
        if (average == node.val) {
            EqualNum++;
        }
        return new int[]{numTotal,sum};
    }
}


/**
 * -> 1
 * 2 -> 1
 * 22 -> 0 + 1 + 1
 * 222 -> 2 + 1 + 1
 * 2222 -> 4 + 2 + 1
 * 22222 ->
 *
 *
 *
 *
 *
 */
