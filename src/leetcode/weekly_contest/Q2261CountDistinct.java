package leetcode.weekly_contest;

import java.util.HashSet;

public class Q2261CountDistinct {
    public int countDistinct(int[] nums, int k, int p) {
        var cnt = 0;
        var first = 0;
        var sec = 0;
        var len = nums.length;
        var allCombi = new HashSet<String>();
        while (sec < len) {
            if (nums[sec] % p == 0) {
                cnt++;
            }

            while (cnt > k) {
                if (nums[first] % p == 0) {
                    cnt--;
                }
                first++;
            }
            var builder = new StringBuilder();
            for (int i = sec; i >= first; i--) {
                builder.append("|");
                builder.append(nums[i]);
                allCombi.add(builder.toString());
            }
            sec++;
            allCombi.forEach(System.out::println);
            System.out.println("-----");

        }
        return allCombi.size();


    }
}
