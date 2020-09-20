package com.jasper.algs.contest.biweekly.bc13.qu1259.solu1;

/**
 * 1259. 不相交的握手
 * 
 * <p> 动态规划
 */
class Solution {
    private static final int MOD = 1_000_000_007;
    public int numberOfWays(int num_people) {
        long[] dp = new long[num_people+1];
        dp[0] = dp[2] = 1;

        for(int n=4; n<=num_people; n+=2) {
            for(int x=0; x<n; x+=2) {
                dp[n] += dp[x] * dp[n-x-2];
                dp[n] %= MOD;
            }
        }

        return (int)dp[num_people];
    }
}