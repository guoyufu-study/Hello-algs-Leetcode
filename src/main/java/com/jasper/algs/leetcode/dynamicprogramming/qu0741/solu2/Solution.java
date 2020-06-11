package com.jasper.algs.leetcode.dynamicprogramming.qu0741.solu2;

import java.util.Arrays;

/**
 * 0741. 摘樱桃
 * 
 * <p>
 * 动态规划：(自底向上）
 */
class Solution {
	public int cherryPickup(int[][] grid) {

		int N = grid.length;
		
		// 初始化上一层缓存
		int[][] dp = new int[N][N];
		for (int[] row : dp)
			Arrays.fill(row, Integer.MIN_VALUE);
		dp[0][0] = grid[0][0]; // t=0，即 从(0,0), (0,0)起步

		for (int t = 1; t <= 2 * N - 2; ++t) {
			
			// 初始化当前层缓存
			int[][] dp2 = new int[N][N];
			for (int[] row : dp2)
				Arrays.fill(row, Integer.MIN_VALUE);
			
			// 计算
			for (int i = Math.max(0, t - (N - 1)); i <= Math.min(N - 1, t); ++i) {
				for (int i2 = Math.max(0, t - (N - 1)); i2 <= Math.min(N - 1, t); ++i2) {
					// 荆棘
					if (grid[i][t - i] == -1 || grid[i2][t - i2] == -1)
						continue;
					
					// 同一格
					int val = grid[i][t - i];
					// 不同格
					if (i != i2)
						val += grid[i2][t - i2];
					
					for (int pi = i - 1; pi <= i; ++pi)
						for (int pi2 = i2 - 1; pi2 <= i2; ++pi2)
							if (pi >= 0 && pi2 >= 0)
								dp2[i][i2] = Math.max(dp2[i][i2], dp[pi][pi2] + val);
				}
			}
			dp = dp2;
		}
		return Math.max(0, dp[N - 1][N - 1]);

	}
}