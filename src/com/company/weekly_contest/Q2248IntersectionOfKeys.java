package com.company.weekly_contest;

import java.util.*;
import java.util.stream.Collectors;

public class Q2248IntersectionOfKeys {

    public static List<Integer> intersection(int[][] nums) {
        var arrLength = nums.length;
        var commonElements = new HashMap<Integer, Integer>(arrLength);
        for (int[]elements : nums){
            for (int element: elements){
                commonElements.put(element, commonElements.getOrDefault(element, 0) + 1);
            }
        }
        return commonElements.entrySet()
                .stream()
                .filter(q -> q.getValue() == arrLength)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
