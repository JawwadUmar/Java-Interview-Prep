package org.jawwad.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class A_K_Is_Important {

    private void solve(Scanner sc){
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i =1; i<=n; i++){
            arr[i] = sc.nextInt();
        }

        long sum = 0;
        int totalOps = n -k +1;
        ArrayList<Integer> vec = new ArrayList<>();
        for(int i = 1; i<=n; i++){
            if(i>=k && i<=(n-k+1)){
                sum+= arr[i];
                totalOps--;
                continue;
            }
            vec.add(arr[i]);
        }

        int l = 0;
        int r = vec.size()-1;

        while (totalOps>0){
            sum+= Math.max(vec.get(l), vec.get(r));
            l++;
            r--;
            totalOps--;
        }

        System.out.println(sum);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        A_K_Is_Important obj = new A_K_Is_Important();
        int t = sc.nextInt();
        while (t>0){
            obj.solve(sc);
            t--;
        }

    }
}
