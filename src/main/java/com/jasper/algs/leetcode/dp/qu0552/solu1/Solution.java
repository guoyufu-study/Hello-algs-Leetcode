package com.jasper.algs.leetcode.dp.qu0552.solu1;

/**
 * 0552. 学生出勤记录 II
 * 
 * <p> 动态规划
 */
class Solution {

    public int checkRecord(int n) {
    	int MOD = 1_000_000_007;
        long[][] dp = new long[n+1][7];
        if(n>=1) dp[1] = new long[] {1, 0, 0, 0, 1, 0, 1};
        for(int i=2; i<=n; i++) {
            dp[i][0] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6])%MOD;// 有A，且是最后一个
            dp[i][1] = dp[i-1][5];// 有A，最后两个是L
            dp[i][2] = dp[i-1][6];// 无A，最后两个是L
            dp[i][3] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][5])%MOD;// 有A，最后是P
            dp[i][4] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6])%MOD;//无A，最后是P
            dp[i][5] = (dp[i-1][0] + dp[i-1][3])%MOD;// 有A，最后一个是L
            dp[i][6] = dp[i-1][4];// 无A，最后一个是L
        }

        return (int)((dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4] + dp[n][5] + dp[n][6])%MOD);
    }
}