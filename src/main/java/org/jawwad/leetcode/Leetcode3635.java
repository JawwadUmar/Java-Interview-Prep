package org.jawwad.leetcode;

public class Leetcode3635 {

    //BRUTE FORCE
//    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
//        int n = landStartTime.length;
//        int m = waterStartTime.length;
//
//        int earliestPossibleTime = Integer.MAX_VALUE;
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<m; j++){
//
//                int p1 = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];
//                int p2 = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i]) + landDuration[i];
//
//                if(earliestPossibleTime > Math.min(p1, p2)){
//                    earliestPossibleTime = Math.min(p1, p2);
//                }
//
//            }
//        }
//
//        return earliestPossibleTime;
//    }

    int findEarliestFinishTime(int[] ride1StartTime, int[] ride1Duration, int[] ride2StartTime, int[] ride2Duration){
        int n = ride1StartTime.length;
        int m = ride2StartTime.length;
        int mnEndingTIme = Integer.MAX_VALUE;

        for(int i =0; i<n; i++){
            mnEndingTIme = Math.min(mnEndingTIme, ride1StartTime[i] + ride1Duration[i]);
        }

        int res = Integer.MAX_VALUE;

        for(int j = 0; j<m; j++){
            int stTime = Math.max(mnEndingTIme, ride2StartTime[j]);
            res = Math.min(res, stTime + ride2Duration[j]);
        }

        return res;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int earliestPossibleTime = findEarliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        earliestPossibleTime = Math.min(earliestPossibleTime, findEarliestFinishTime(waterStartTime, waterDuration, landStartTime, landDuration));

        return earliestPossibleTime;
    }
}
