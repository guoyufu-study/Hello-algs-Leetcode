package com.jasper.algs.interview.qu0811.solu1;


/**
 * 面试题 08.11. 硬币
 * 
 * <p> 动态规划
 */
class Solution {
	private static final int mod = 1_000_000_007;
	private static final int[] coins = new int[] {1, 5, 10, 25};
    public int waysToChange(int n) {
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<4; i++) {
            for(int j=coins[i]; j<=n; j++) {
                dp[j] += dp[j-coins[i]];
                dp[j] %= mod;
            }
        }
        return dp[n];
    }
}