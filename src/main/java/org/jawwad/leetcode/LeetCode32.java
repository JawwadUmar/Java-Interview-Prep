package org.jawwad.leetcode;

public class LeetCode32 {

    public int longestValidParentheses(String s) {
        int n = s.length();
        int countOpen = 0;
        int countClose = 0;
        int res = 0;

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '('){
                countOpen++;
            }
            else if(ch == ')'){
                countClose++;
            }

            if(countOpen < countClose ){
                countClose = 0;
                countOpen = 0;
            }
            else if(countOpen == countClose){
                res = Math.max(res, countClose*2);
            }
        }

        countOpen = 0;
        countClose = 0;

        for(int i = n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == ')'){
                countClose++;
            }
            else if(ch == '('){
                countOpen++;
            }

            if(countOpen > countClose ){
                countClose = 0;
                countOpen = 0;
            }
            else if(countOpen == countClose){
                res = Math.max(res, countClose*2);
            }
        }

        return res;
    }
}
