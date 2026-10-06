package org.jawwad.leetcode;

import java.util.Stack;

public class LeetCode921 {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i<n){
            int j = i;
            while (j<n && s.charAt(j)==')' && !st.empty() && st.peek()=='('){
                st.pop();
                j++;
            }
            if(j ==n){
                break;
            }
            i = j;
            st.push(s.charAt(i));
            i++;

        }

        return st.size();
    }
}
