package org.jawwad.leetcode;

public class Leetcode868 {

    public int binaryGap(int n) {
        int currentPos = 0;
        int lastPos = -1;
        int res = 0;

        while (n!= 0){
            int bit = n%2;
            if(bit == 1){
                if(lastPos!= -1){
                    res = Math.max(currentPos - lastPos, res);
                }
                lastPos = currentPos;
            }
            n =n/2;
            currentPos++;
        }
        return res;
    }
}
