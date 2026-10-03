package io.deliveroo.demo;

import java.util.Arrays;

public class Leetcode1886 {
    private void rotateMat(int[][] mat){
        int n = mat.length;
        int [][] newMat = new int[n][n];

        //Take Transpose
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                newMat[i][j] = mat[j][i];
            }
        }

        //ReverseRows
        for(int i = 0; i<n; i++){
            int j = 0;
            int k = n-1;

            while (k > j){
                newMat[i][j] = newMat[i][j]^newMat[i][k];
                newMat[i][k] = newMat[i][j]^newMat[i][k];
                newMat[i][j] = newMat[i][j]^newMat[i][k];
                k--;
                j++;
            }
        }

        mat = newMat;
    }

    public boolean findRotation(int[][] mat, int[][] target) {

        for(int i = 0; i<4; i++){
            if(mat == target){
                return true;
            }
            System.out.println(mat);

            rotateMat(mat);
        }

        return false;
    }
}
