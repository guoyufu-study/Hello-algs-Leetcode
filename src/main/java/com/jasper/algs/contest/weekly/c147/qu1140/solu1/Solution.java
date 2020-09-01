package com.jasper.algs.contest.weekly.c147.qu1140.solu1;

import java.util.Arrays;

/**
 * 1140. 石子游戏 II
 * 
 * <p> 记忆化搜索
 */
class Solution {
	static final int DEFAULT_VALUE = -1_000_001;
	int n;
	int[] prefixSum;
	int[][] memo;
    public int stoneGameII(int[] piles) {
    	// 前缀和
    	n = piles.length;
    	prefixSum = new int[n+1];
    	for (int i = 0; i < n; i++) 
			prefixSum[i+1] = prefixSum[i] + piles[i];
		
    	// 记忆化搜索
    	memo = new int[n][n];
    	for (int i = 0; i < n; i++) {
			Arrays.fill(memo[i], DEFAULT_VALUE);
		}
    	int diff = dfs(0, 1);
    	
    	return (prefixSum[n] + diff) / 2;
    }
    
	private int dfs(int begin, int M) {
		if(n - begin <= 2*M) { // 一次取完
			return prefixSum[n] - prefixSum[begin];
		}
		
		if(memo[begin][M] != DEFAULT_VALUE) // 已求解过
			return memo[begin][M];
		
		// 先手取 1 ~ 2M 个
		for (int x = 1; x <= 2 * M /* && begin+x<=n */; x++) {
			memo[begin][M] = Math.max(memo[begin][M], 
					prefixSum[begin+x] -  prefixSum[begin] - dfs(begin+x, Math.max(M, x)));
		}
		
		return memo[begin][M];
	}
}