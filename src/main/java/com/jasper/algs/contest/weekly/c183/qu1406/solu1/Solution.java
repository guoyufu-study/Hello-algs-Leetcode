package com.jasper.algs.contest.weekly.c183.qu1406.solu1;

import java.util.Arrays;

/**
 * 1406. 石子游戏 III
 * 
 * <p> 记忆化搜索
 */
public class Solution {

	public String stoneGameIII(int[] stoneValue) {
		int n = stoneValue.length;
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[n] = 0;
		dfs(dp, stoneValue, n, 0);
		return dp[0]>0 ? "Alice" : dp[0]==0 ? "Tie" : "Bob";
    }

	private int dfs(int[] dp, int[] stoneValue, int n, int i) {
		
		if(dp[i]!=Integer.MIN_VALUE) return dp[i];
		
		if(i<=n-1)
			dp[i] = stoneValue[i] - dfs(dp, stoneValue, n, i+1);
		if(i<=n-2) 
			dp[i] = Math.max(dp[i], stoneValue[i]+stoneValue[i+1] - dfs(dp, stoneValue, n, i+2));
			
		if(i<=n-3)
			dp[i] = Math.max(dp[i], stoneValue[i]+stoneValue[i+1]+stoneValue[i+2] - dfs(dp, stoneValue, n, i+3));

		return dp[i];
	}
}
