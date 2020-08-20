package com.jasper.algs.leetcode.dp.qu0063.solu2;


/**
 * 0063.不同路径 II
 *
 * <p>动态规划：一维DP
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	// 边界
    	if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0)
    		return 0;
    	// 行列
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	
    	// 一维DP
    	int[] helper = new int[n];
    	helper[0] = obstacleGrid[0][0]==0 ? 1 : 0;
    	for (int j = 1; j < n; j++) {
    		helper[j] = obstacleGrid[0][j]==0 ? helper[j-1] : 0;
		}
    	
    	for (int i = 1; i < m; i++) {
    		helper[0] = obstacleGrid[i][0]==0 ? helper[0] : 0;
			for (int j = 1; j < n; j++) {
				helper[j] = obstacleGrid[i][j]==0 ? 
						helper[j] + helper[j-1] : 0;
			}
		}
    	
    	return helper[n-1];
    }
}