package org.jawwad.leetcode;

public class Leetcode1680 {
    private static final long MOD = 1000_000_007;

    public int concatenatedBinary(int n) {
        long  ans = 0;
        int bits = 0;
        for (int i =1; i<=n; i++){
            if((i&(i-1)) == 0){
                bits++;
            }
            int x = (i<<bits);
            ans = (ans | x);
            ans = ans%MOD;
        }

        return (int) ans;
    }
}
