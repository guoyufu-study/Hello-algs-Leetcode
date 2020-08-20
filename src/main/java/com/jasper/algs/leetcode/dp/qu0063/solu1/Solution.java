package com.jasper.algs.leetcode.dp.qu0063.solu1;


/**
 * 0063.不同路径 II
 *
 * <p>动态规划：二维DP
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	// 边界
    	if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
    		return 0;
    	// 行列
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	// 二维DP
    	int[][] helper = new int[m][n];
    	helper[0][0] = obstacleGrid[0][0] ^ 1;
    	for (int i = 1; i < m; i++) 
    		helper[i][0] = obstacleGrid[i][0]==0 ? helper[i-1][0] : 0;
    	for (int j = 1; j < n; j++) 
    		helper[0][j] = obstacleGrid[0][j]==0 ? helper[0][j-1] : 0;
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
					helper[i][j] = obstacleGrid[i][j]==0 ? 
							helper[i-1][j] + helper[i][j-1] : 0;
			}
		}
    	
    	return helper[m-1][n-1];
    }
}