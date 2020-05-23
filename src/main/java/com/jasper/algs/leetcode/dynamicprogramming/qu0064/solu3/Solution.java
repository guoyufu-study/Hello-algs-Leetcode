package com.jasper.algs.leetcode.dynamicprogramming.qu0064.solu3;


/**
 * 0064. 最小路径和
 *
 * <p>动态规划：一维DP
 */
class Solution {
    public int minPathSum(int[][] grid) {
    	
    	// 边界
    	if(grid==null ||
    			grid.length==0 || grid[0].length==0)
    		return 0;
    	
    	int m = grid.length;
    	int n = grid[0].length;
    	
    	// 一维DP
    	int[] dp = new int[n];
    	dp[0] = grid[0][0];
    	for (int j = 1; j < n; j++)
			dp[j] = dp[j-1] + grid[0][j];
    	for (int i = 1; i < m; i++) {
    		dp[0] += grid[i][0];
			for (int j = 1; j < n; j++) {
				dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
			}
		}
    	
    	return dp[n-1];
    }
}