package org.jawwad.codeforces;

import java.util.Scanner;

public class A_SauSaGe_Bank {
    private void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n == k){
            System.out.println(2*k);
            return;
        }

        long amount = 2L *(k-1);
        long expAmount = 1;
        long expDays =  (n - k + 1);
        while (expDays > 0){
            expAmount = expAmount*2;
            expDays--;
        }

        amount+= expAmount;
        System.out.println(amount);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A_SauSaGe_Bank obj = new A_SauSaGe_Bank();
        int t = sc.nextInt();
        while (t!=0){
            obj.solve(sc);
            t--;
        }
        sc.close();
    }
}
