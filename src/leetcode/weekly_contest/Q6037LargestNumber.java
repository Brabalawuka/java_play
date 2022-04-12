package leetcode.weekly_contest;

import java.util.*;

public class Q6037LargestNumber {

    public static int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Boolean> position = new ArrayList<>();
        String numStr = Integer.toString(num);
        for (int i = 0; i < numStr.length(); i++) {
            int character = Integer.parseInt(String.valueOf(numStr.charAt(i)));
            if (character % 2 == 0) {
                even.add(character);
                position.add(true);
            } else {
                odd.add((character));
                position.add(false);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Boolean isEven : position) {
            if (isEven){
                builder.append(even.poll());
            } else {
                builder.append(odd.poll());
            }
        }
        return Integer.parseInt(builder.toString());
    }

}
