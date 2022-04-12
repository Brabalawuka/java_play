package leetcode.weekly_contest;

import java.util.*;

public class Q5235FindWinners {
    public static List<List<Integer>> findWinners(int[][] matches) {
        TreeMap<Integer, Boolean> winners = new TreeMap();
        TreeMap<Integer, Boolean> oneLosers = new TreeMap();
        HashMap<Integer, Boolean> losers = new HashMap<>();
        for (int[] match : matches) {
            if (!losers.containsKey(match[0]) && !oneLosers.containsKey(match[0])) {
                winners.put(match[0], true);
            }
            if (oneLosers.containsKey(match[1])) {
                oneLosers.remove(match[1]);
                losers.put(match[1], true);
            } else if (winners.containsKey(match[1])) {
                winners.remove(match[1]);
                oneLosers.put(match[1], true);
            }
            if (!losers.containsKey(match[1])){
                oneLosers.put(match[1], true);
            }
        }
        List<Integer> winnerArray = winners.keySet().stream().toList();
        List<Integer> oneLoserArray = oneLosers.keySet().stream().toList();
        return new ArrayList<>(Arrays.asList(winnerArray, oneLoserArray));
    }
}
