package org.jawwad.leetcode;

public class Leetcode1404 {

    private StringBuilder addOne(StringBuilder sb){
        int n = sb.length();
        int carry = 1;
        for(int i = n-1; i>=0; i--){
            int digit = sb.charAt(i) - '0';
            int res = digit+carry;
            carry= res/2;
            res = res%2;
            char ch = (char)('0' + res);
            sb.setCharAt(i, ch);
        }

        if(carry > 0){
            sb.insert(0, "1");
        }
        return sb;
    }

    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int cnt = 0;
        while (!sb.toString().equals("1")){
            if(sb.charAt(sb.length()-1) == '1'){
                addOne(sb);
            }
            else{
                sb.deleteCharAt(sb.length()-1);
            }
            cnt++;
        }
        return cnt;
    }
}
