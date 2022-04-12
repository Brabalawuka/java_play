package leetcode.weekly_contest;

import java.util.Collections;
import java.util.PriorityQueue;

public class Q6039MaxProAftKInc {
    public static int maximumProduct(int[] nums, int k) {

        var minHeap = new PriorityQueue<Long>(nums.length);
        for (int num : nums) {
            minHeap.add(Long.valueOf(num));
        }
        while (k > 0){
            var first = minHeap.poll();
            first += 1;
            k -= 1;
            minHeap.add(first);
        }
        return (int) (minHeap.stream().reduce(1L,(a, b) -> a % (1000000000 +7) * b) % (1000000000 +7));
    }

}
