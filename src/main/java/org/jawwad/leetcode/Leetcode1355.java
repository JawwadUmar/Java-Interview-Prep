package org.jawwad.leetcode;

import java.util.Arrays;
import java.util.List;

public class Leetcode1355 {

    private int countBits(Integer x){
        int cnt = 0;
        while (x!=0){
            cnt+= x%2;
            x = x/2;
        }
        return cnt;
    }

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums,  ( a,  b)->{
            int i = Integer.bitCount(a) - Integer.bitCount(b);
            if(i!=0){
                return i;
            }
            return a-b;
        });

        return Arrays.stream(nums).mapToInt(i->i).toArray();
    }
}
