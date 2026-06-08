package org.jawwad.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int count = 0;

        for(int i = 0; i<n; i++){
            if(nums[i] < pivot){
                left.add(nums[i]);
            }
            else if(nums[i] > pivot){
                right.add(nums[i]);
            }
            else{
                count++;
            }
        }

        int[] res = new int[n];
        int i = 0;
        for(int x: left){
            res[i] = x;
            i++;
        }

        while (count>0){
            res[i] = pivot;
            i++;
            count--;
        }

        for(int x: right){
            res[i] = x;
            i++;
        }

        return res;
    }
}
