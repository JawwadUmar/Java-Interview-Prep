package org.jawwad.leetcode;

import java.util.Stack;

public class LeetCode678 {
    int[][] dp;
    boolean[][]t;
    private boolean checkValidStringRecursion(int idx, int openCount, String s){
        int n = s.length();
        if(idx == n){
            return openCount==0;
        }
        if(openCount<0){
            return false;
        }

        if(dp[idx][openCount] != -1){
            return dp[idx][openCount] ==1;
        }

        char ch = s.charAt(idx);
        if(ch == '('){
            return checkValidStringRecursion(idx+1, openCount+1, s);
        }
        if(ch == ')'){
            return checkValidStringRecursion(idx+1, openCount-1, s);
        }

        boolean flag =  checkValidStringRecursion(idx+1, openCount+1, s) || checkValidStringRecursion(idx+1, openCount-1, s) || checkValidStringRecursion(idx+1, openCount, s);
        if(flag){
            dp[idx][openCount] = 1;
        }
        else{
            dp[idx][openCount] = 0;
        }
        return flag;
    }

    private boolean checkValidStringBottomUp(String s){
        int n = s.length();
        t = new boolean[n+1][n+1];
        t[n][0] = true;

        for(int i= n-1; i>=0; i--){
            for(int open = 0; open<=n; open++){
                char ch = s.charAt(i);
                if(ch == '('){
                    t[i][open] = t[i+1][open+1];
                }
                else if(ch == ')' && open-1>=0){
                    t[i][open] = t[i+1][open-1];
                }
                else{
                    if(open-1>=0){
                        t[i][open] = t[i][open] || t[i+1][open-1];
                    }
                    if(open+1<=n){
                        t[i][open] = t[i][open] || t[i+1][open+1];
                    }
                    t[i][open] = t[i][open] || t[i+1][open];
                }

            }
        }

        return t[0][0];
    }
    public boolean checkValidStringUsingStack(String s) {
        int n = s.length();
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> astrixStack = new Stack<>();

        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                astrixStack.push(i);
                continue;
            }
            else if(ch == '('){
                openStack.push(i);
                continue;
            }

            if(!openStack.empty()){
                openStack.pop();
            }
            else if(!astrixStack.empty()){
                astrixStack.pop();
            }
            else{
                return false;
            }
        }

        while (!openStack.empty()){
            if(astrixStack.empty()){
                return false;
            }
            int openBracketPos = openStack.pop();
            int astrixPos = astrixStack.pop();

            if(astrixPos< openBracketPos){
                return false;
            }
        }

        return true;
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        int countOpen = 0;
        int countClose = 0;
        int countStar = 0;

        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '('){
                countOpen++;
            }
            else if(s.charAt(i) == ')'){
                countClose++;
            }
            else{
                countStar++;
            }

            if(countClose > countOpen){
                int diff = countClose - countOpen;
                if(countStar < diff){
                    return false;
                }
                else{
                    countOpen+=diff;
                    countStar-=diff;
                }
            }
        }

        countStar = countClose = countOpen = 0;

        for(int i = n-1; i>=0; i--){
            if(s.charAt(i) == '('){
                countOpen++;
            }
            else if(s.charAt(i) == ')'){
                countClose++;
            }
            else{
                countStar++;
            }

            if(countOpen > countClose){
                int diff = countOpen - countClose;
                if(countStar < diff){
                    return false;
                }
                else{
                    countClose+=diff;
                    countStar-=diff;
                }
            }
        }

        return true;

    }
}
