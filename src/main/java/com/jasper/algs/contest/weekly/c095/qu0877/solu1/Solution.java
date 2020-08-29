package com.jasper.algs.contest.weekly.c095.qu0877.solu1;

/**
 * 0877. 石子游戏
 * 
 * <p> 动态规划
 */
class Solution {
    public boolean stoneGame(int[] piles) {
    	int n = piles.length;
    	int[][] dp = new int[n][n];
    	
    	for (int i = 0; i < n; i++) {
    		dp[i][i] = piles[i];
		}
    	for(int i=n-1; i>=0; i--) {
    		for (int j = i+1; j < n; j++) {
				dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
			}
    	}
    	
    	return dp[0][n-1]>0;
    }
}