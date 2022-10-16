package com.company.weekly_contest;

import java.util.ArrayList;
import java.util.HashMap;

public class Q6108DecodeMessage {

    public static Character[] ValMap = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static String decodeMessage(String key, String message) {
        var keyMap = new HashMap<Character, Character>();
        var currPosition = 0;
        for (Character c:  key.toCharArray()) {

            if (keyMap.containsKey(c)){
                continue;
            } else if (c == ' '){
                keyMap.put(c, ' ');
            } else {
                keyMap.put(c, ValMap[currPosition]);
                currPosition++;
            }
        }
        var builder = new StringBuilder();
        for (Character c : message.toCharArray()){
            if (c == ' ') {
                builder.append(' ');
                continue;
            }
            builder.append(keyMap.get(c));
        }
        return builder.toString();
    }


}
