package com.company.weekly_contest;

import java.util.*;

public class Q5234RemoveAnagrams {


//    public static List<String> removeAnagrams(String[] words) {
//        var result = new ArrayList<String>();
//
//        var wordsMap = new LinkedHashMap<String, String>();
//        int starting = 'a';
//        for (String word: words){
//            var appearance = new int[26];
//            for (char cha: word.toCharArray()){
//                 int position = cha - starting;
//                 appearance[position] = appearance[position] + 1;
//            }
//            System.out.println(Arrays.toString(appearance));
//            var arrStr = Arrays.toString(appearance);
//            wordsMap.putIfAbsent(arrStr, word);
//        }
//        return wordsMap.values().stream().toList();
//    }

    public static List<String> removeAnagrams(String[] words) {
        var result = new ArrayList<String>();

        var prev = "";
        for (String word: words){
            var appearance = new int[26];
            for (char cha: word.toCharArray()){
                int position = cha - 'a';
                appearance[position] = appearance[position] + 1;
            }
            System.out.println(Arrays.toString(appearance));
            var arrStr = Arrays.toString(appearance);
            if (!prev.equals(arrStr)){
               prev = arrStr;
               result.add(word);
            }
        }
        return result;
    }


}
