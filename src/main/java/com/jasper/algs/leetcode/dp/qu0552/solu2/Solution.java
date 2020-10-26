package com.jasper.algs.leetcode.dp.qu0552.solu2;

/**
 * 0552. 学生出勤记录 II
 * 
 * <p> 动态规划
 */
class Solution {

    public int checkRecord(int n) {
    	int MOD = 1_000_000_007;
        long[] dp = new long[n<5 ? 6 : n+1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for(int i=4; i<=n; i++) {
        	dp[i] = (2 * dp[i-1] + MOD - dp[i-4])%MOD;
        }
        long sum = dp[n];
        for(int i=1; i<=n; i++) {
        	sum += (dp[i-1] * dp[n-i])%MOD;
        }
        return (int)(sum%MOD);
    }
}