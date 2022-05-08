package com.company.weekly_contest;

import java.util.*;

public class Q5302Encrypter {

    class TreeNode {
        char selfChar;
        boolean isEnd;
        HashMap<Character, TreeNode> children;
        public TreeNode(char selfChar){
            this.selfChar = selfChar;
            children = new HashMap<>();
        }
        public TreeNode AddWord(String word){
            if (word.length() == 0) {
                return null;
            }
            TreeNode child = null;
            if (children.containsKey(word.charAt(0))){
                child = children.get(word.charAt(0));
            } else {
                child = new TreeNode(word.charAt(0));
            }
            if (word.length() > 1) {
                child.AddWord(word.substring(1));
            } else {
                child.isEnd = true;
            }
            children.put(word.charAt(0), child);
            return this;
        }

    }

    public TreeNode RootNode;
    public HashMap<Character, String> encryption;
    public HashMap<String, Set<Character>> decryption;

    public Q5302Encrypter(char[] keys, String[] values, String[] dictionary) {
        if (keys.length != values.length) {
            return;
        }
        decryption = new HashMap<>();
        encryption = new HashMap<>();
        RootNode = new TreeNode(' ');
        for (int i = 0; i < keys.length; i++) {
            encryption.put(keys[i], values[i]);
            if (decryption.containsKey(values[i])){
                decryption.get(values[i]).add(keys[i]);
            } else {
                decryption.put(values[i], new HashSet<>(Arrays.asList(keys[i])));
            }
        }
        for (String word : dictionary) {
            RootNode.AddWord(word);
        }
    }

    public String encrypt(String word1) {
        var builder = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            builder.append(encryption.get(word1.charAt(i)));
        }
        return builder.toString();
    }

    public int decrypt(String word2) {

        if (word2.length()%2 != 0) {
            return 0;
        }
        List<TreeNode> candidates = new ArrayList<>(Arrays.asList(RootNode));
        for (int i = 0; i < word2.length(); i=i+2) {

            if (candidates.size() == 0) {
                return 0;
            }
            List<TreeNode> newCandidates = new ArrayList<>();
            String substring = word2.substring(i,i+2);
            Set<Character> candidateChars = decryption.get(substring);
            if (candidateChars == null){
                return 0;
            }
            for (TreeNode candidate : candidates) {
                for (Character candidateChar : candidateChars) {
                    if (candidate.children.containsKey(candidateChar)){
                        newCandidates.add(candidate.children.get(candidateChar));
                    }
                }
            }
            candidates = newCandidates;
        }
        int total = 0;
        for (TreeNode candidate : candidates) {
            if (candidate.isEnd) {
                total++;
            }
        }
        return total;
    }


}