package com.jasper.algs.contest.weekly.c165.qu1277.solu1;


/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 
 * <p> 动态规划
 */
class Solution {
    public int countSquares(int[][] matrix) {

    	int n = matrix.length, m = matrix[0].length, ans = 0;
    	
    	int[][] dp = new int[n][m];
    	for(int j=0; j<m; j++) {
    		dp[0][j] = matrix[0][j];
    		ans += dp[0][j];
    	}
    	
    	for (int i = 1; i < n; i++) {
			dp[i][0] = matrix[i][0];
			ans += dp[i][0];
			for (int j = 1; j < m; j++) {
				if(matrix[i][j]==1) {
					dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
					ans += dp[i][j];
				}
			}
		}
    	return ans;
    }
}