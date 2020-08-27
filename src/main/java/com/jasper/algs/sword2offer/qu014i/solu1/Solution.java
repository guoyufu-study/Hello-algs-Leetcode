package com.jasper.algs.sword2offer.qu014i.solu1;

/**
 * 剑指 Offer 14- I. 剪绳子
 * 
 * <p> 动态规划
 */
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<n; i++) 
        	dp[i] = i;
        
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i-j]);
            }
        }
        return dp[n];
    }
}