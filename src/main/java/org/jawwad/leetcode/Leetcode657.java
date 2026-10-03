package io.deliveroo.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Leetcode657 {
    public boolean judgeCircle(String moves) {
        int n = moves.length();
//        'U', 'D', 'R', 'L'
        Map<Character, Integer> mp = new HashMap<>();

        for(int i = 0; i<moves.length(); i++){
            mp.put(moves.charAt(i), mp.getOrDefault(moves.charAt(i), 0) +1);
        }

        if(mp.getOrDefault('U', 0).equals(mp.getOrDefault('D', 0))  &&
                Objects.equals(mp.getOrDefault('R', 0), mp.getOrDefault('L', 0))){
            return true;
        }

        return false;
    }
}