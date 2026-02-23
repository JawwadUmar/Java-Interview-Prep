package org.jawwad.leetcode;

import java.util.*;

public class Leetcode3721 {
    private List<Integer> minSegTree = new ArrayList<>();
    private List<Integer> maxSegTree = new ArrayList<>();

    private void giveSize(int n){
        for(int i = 0; i<4*n; i++){
            maxSegTree.add(0);
            minSegTree.add(0);
        }
    }

    private void buildMaxSegTree(int idx, int l, int r, int[] currSum){
        if(l == r){
            maxSegTree.set(idx, currSum[l]);
            return;
        }

        int mid = (l+r)/2;
        buildMaxSegTree(2*idx+1, l, mid, currSum);
        buildMaxSegTree(2*idx+2, mid+1, r, currSum);

        maxSegTree.set(idx, Math.max(maxSegTree.get(2*idx+1), maxSegTree.get(2*idx+2)));
    }

    private void buildMinSegTree(int idx, int l, int r, int[] currSum){
        if(l == r){
            minSegTree.set(idx, currSum[l]);
            return;
        }

        int mid = (l+r)/2;
        buildMinSegTree(2*idx+1, l, mid, currSum);
        buildMinSegTree(2*idx+2, mid+1, r, currSum);

        minSegTree.set(idx, Math.min(minSegTree.get(2*idx+1), minSegTree.get(2*idx+2)));
    }

    private void updateMaxSegTree(int idx, int l, int r, int val){
        if(l == r){
            maxSegTree.set(idx, maxSegTree.get(idx) + val);
            return;
        }
        int mid = (l+r)/2;
        updateMaxSegTree(2*idx+1, l, mid, val);
        updateMaxSegTree(2*idx+2, mid+1, r, val);

        maxSegTree.set(idx, Math.max(maxSegTree.get(2*idx+1), maxSegTree.get(2*idx+2)));

    }

    private void updateMinSegTree(int idx, int l, int r, int val){
        if(l == r){
            minSegTree.set(idx, minSegTree.get(idx) + val);
            return;
        }
        int mid = (l+r)/2;
        updateMinSegTree(2*idx+1, l, mid, val);
        updateMinSegTree(2*idx+2, mid+1, r, val);

        minSegTree.set(idx, Math.min(minSegTree.get(2*idx+1), minSegTree.get(2*idx+2)));

    }

    private int findLeftMostZero(int idx, int l, int r, int[]currSum){
        if(maxSegTree.get(idx) <0 || minSegTree.get(idx) > 0){
            return -1;
        }
        if(l == r){
            return l;
        }

        int mid = (l+r)/2;
        int p1 = findLeftMostZero(2*idx+1, l, mid, currSum);
        if(p1 != -1){
            return p1;
        }

        return findLeftMostZero(2*idx+2, mid+1, r, currSum);
    }

        public int longestBalanced(int[] nums) {
            int n = nums.length;
            int res = 0;
            Map<Integer, Integer> mp = new HashMap<>();
            int[] currSum = new int[n];
            giveSize(n);
            buildMaxSegTree(0, 0, n-1, currSum);
            buildMinSegTree(0, 0, n-1, currSum);

            for(int r = 0; r<n; r++){
                int val = (nums[r]%2 == 0) ? 1 : -1;
                int prev = mp.getOrDefault(nums[r], -1);

                //Update(prev+1, r, val)
//                for(int j = prev+1; j<=r; j++){
//                    currSum[j]+= val;
//                }

                updateMaxSegTree(0, prev+1, r, val);
                updateMinSegTree(0, prev+1, r, val);

                //FindFirstOccurrence of 0 Find(0,r)
//                for(int l = 0; l<=r; l++){
//                    if(currSum[l] == 0){
//                        res = Math.max(res, r-l+1);
//                        break;
//                    }
//                }

                int l = findLeftMostZero(0, 0, r, currSum);
                res = Math.max(res, r-l+1);
                mp.put(nums[r], r);
            }
            return res;
        }
}
