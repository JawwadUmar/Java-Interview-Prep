package org.jawwad.leetcode;

public class Leetcode1689 {
    public int minPartitions(String n) {
        char ch = n.charAt(0);
        int i = 1;
        while(i<n.length()){
            if(n.charAt(i) > ch){
                ch = n.charAt(i);
            }
            i++;
        }

        return ch - '0';

    }
}
