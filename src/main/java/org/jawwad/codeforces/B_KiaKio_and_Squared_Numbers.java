package org.jawwad.codeforces;

import java.util.Scanner;

public class B_KiaKio_and_Squared_Numbers {

    private int calculateSqSum(int x){
        int res = 0;
        while (x!= 0){
            int dig = x%10;
            res+= dig*dig;
            x = x/10;
        }

        return res;
    }

    private boolean inTune(int x, int y, int count){
        if(x == y){
            return true;
        }
        if(count > 50){
            return false;
        }

        int sq_x = calculateSqSum(x);
        int sq_y = calculateSqSum(y);

        return inTune(sq_x, sq_y, count+1);
    }

    private void solve(Scanner sc){
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int res = 0;

        for(int i =0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(inTune(a[i], a[j], 0)){
                    res++;
                }
            }
        }

        System.out.println(res);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        B_KiaKio_and_Squared_Numbers obj = new B_KiaKio_and_Squared_Numbers();
        while (t>0){
            obj.solve(sc);
            t--;
        }
        sc.close();
    }
}
