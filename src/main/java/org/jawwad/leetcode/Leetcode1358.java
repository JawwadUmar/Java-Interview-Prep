package org.jawwad.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1358 {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>();

        int i = 0;
        int j = 0;
        int res = 0;

        while (j < n) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            if (mp.getOrDefault('a', 0) > 0 && mp.getOrDefault('b', 0) > 0 && mp.getOrDefault('c', 0) > 0) {
                res += n - j;
                mp.compute(s.charAt(i), (k, freq) -> freq - 1);
                i++;
            } else {
                j++;
            }
        }

        return res;
    }
}