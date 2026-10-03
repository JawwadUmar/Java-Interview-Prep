package io.deliveroo.demo;

public class Leetcode3653 {
    int MOD = 1000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int m = queries.length;
        long [] longNums = new long[nums.length];

        for(int i = 0; i<nums.length; i++){
            longNums[i] = nums[i];
        }

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            for (int idx = l; idx <= r; idx = idx + k) {
                longNums[idx] = (longNums[idx] * v);
            }
        }

        long res = 0;

        for(long x: nums){
            res = res^x;
        }
        return (int) res;
    }
}
