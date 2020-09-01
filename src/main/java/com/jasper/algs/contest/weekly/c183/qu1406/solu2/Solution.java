package com.jasper.algs.contest.weekly.c183.qu1406.solu2;

/**
 * 1406. 石子游戏 III
 * 
 * <p> 动态规划
 */
public class Solution {

	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		int[] dp = new int[n+1];
		dp[n-1] = stoneValue[n-1];
		for (int i = n-2; i >= 0; i--) {
			if(i<=n-2) {
				dp[i] = Math.max(stoneValue[i] - dp[i+1], stoneValue[i]+stoneValue[i+1] - dp[i+2]);
			}
			if(i<=n-3)
				dp[i] = Math.max(dp[i], stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - dp[i+3]);
		}
		
		return dp[0]>0 ? "Alice" : dp[0]==0 ? "Tie" : "Bob";
    }
}
