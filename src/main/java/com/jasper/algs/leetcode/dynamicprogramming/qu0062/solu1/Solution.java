package com.jasper.algs.leetcode.dynamicprogramming.qu0062.solu1;


/**
 * 0062. 不同路径
 *
 * <p>动态规划
 */
class Solution {
    public int uniquePaths(int m, int n) {
    	
    	// 二维数组
    	int[][] helper = new int[m][n];
    	for (int i = 0; i < m; i++)
			helper[i][0] = 1;
    	for (int j = 0; j < n; j++)
			helper[0][j] = 1;
    	
    	for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				helper[i][j] = helper[i-1][j] + helper[i][j-1];
    	
    	return helper[m-1][n-1];
    }
}