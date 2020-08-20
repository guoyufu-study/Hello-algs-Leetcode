package com.jasper.algs.leetcode.dp.qu0741.solu1;

import java.util.Arrays;

/**
 * 0741. 摘樱桃
 * 
 * <p> 动态规划：自顶向下
 */
class Solution {
	
	int[][][] memo;
	int[][] grid;
	int N;
	
    public int cherryPickup(int[][] grid) {
    	this.grid = grid;
    	N = grid.length;
    	memo = new int[N][N][N];
    	
    	for (int[][] layer: memo)
            for (int[] row: layer)
                Arrays.fill(row, Integer.MIN_VALUE);
    	
        return Math.max(0, dp(0, 0, 0));

    }

	private int dp(int i, int j, int k) {
		int i2 = i + j -k;
		
		if (N == i || N == i2 || N == j || N == k || // 越界
                grid[i][j] == -1 || grid[i2][k] == -1)  // 荆棘
            return -999;   

        // 终点
        if(i==N-1 && j==N-1) // 此时 i2=N-1, k=N-1，否则(i2, k)已越界
        	return grid[i][j];
        
        // 读缓存
        if (memo[i][j][k] != Integer.MIN_VALUE) 
            return memo[i][j][k];

        // 计算
        int ans = grid[i][j];
        if (j != k) ans += grid[i2][k];
        ans += Math.max(Math.max(dp(i, j+1, k+1), dp(i+1, j, k+1)),
                        Math.max(dp(i, j+1, k), dp(i+1, j, k)));
        memo[i][j][k] = ans;
        return ans;

	}
}