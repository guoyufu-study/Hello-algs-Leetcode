package com.jasper.algs.leetcode.dynamicprogramming.qu0064.solu2;


/**
 * 0064. 最小路径和
 *
 * <p> 动态规划：二维DP
 */
class Solution {
    public int minPathSum(int[][] grid) {
    	// 边界
    	if(grid==null || grid.length==0 || grid[0].length==0)
    		return 0;
    	
    	int m = grid.length;
    	int n = grid[0].length;
    	
    	for (int i = 1; i < m; i++)
			grid[i][0] += grid[i-1][0];
    	for (int j = 1; j < n; j++)
			grid[0][j] += grid[0][j-1];
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}
    	
    	return grid[m-1][n-1];
    }
}