package com.company.daily_challenge;

import java.util.*;

/*
Date: 24th Apr 2023
Note: First question
 */
public class Q1048LongestStringChain {
    public Q1048LongestStringChain() {

    }

    public int longestStrChain(String[] words) {

        // to list
        List<String> wordsList = Arrays.asList(words);

        // sort
        wordsList.sort(Comparator.comparingInt(String::length));

        // Memory of current step
        HashMap<String, Integer> memory = new HashMap<>();
        int max = 1;

        for (String word : wordsList) {
            int currentLength = 1;
            StringBuilder builder = new StringBuilder(word);
            for (int i = 0; i < builder.length(); i++) {
                builder.deleteCharAt(i);
                // word that is one letter shorter, for first word its we get currentlength = 1
                var previous = builder.toString();
                currentLength = Math.max(currentLength, memory.getOrDefault(previous,0) + 1);
                builder.insert(i, word.charAt(i));
            }
            memory.put(word, currentLength);
            max = Math.max(max, currentLength);
        }



        return max;
    }



}
