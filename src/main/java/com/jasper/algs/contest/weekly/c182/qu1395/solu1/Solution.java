package com.jasper.algs.contest.weekly.c182.qu1395.solu1;

/**
 * 1395. 统计作战单位数
 * 
 * <p> 暴力枚举
 */
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    if(rating[i] < rating[j] && rating[j] < rating[k] || rating[i] > rating[j] && rating[j] > rating[k]) ++ans;
                }
            }
        }
        
        return ans;
    }
}