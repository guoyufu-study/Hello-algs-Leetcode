package com.jasper.algs.contest.biweekly.bc30.qu1510.solu1;

/**
 * 1510. 石子游戏 IV
 * 
 * <p>
 * 动态规划
 */
class Solution {
	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
		for (int i = 1; i <= n; ++i) {
			for (int k = 1; k * k <= i; ++k) {
				if (!dp[i - k * k]) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n];
	}
}