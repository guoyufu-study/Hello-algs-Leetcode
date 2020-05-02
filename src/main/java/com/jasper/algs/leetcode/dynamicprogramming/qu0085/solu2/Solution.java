package com.jasper.algs.leetcode.dynamicprogramming.qu0085.solu2;

/**
 * 0221. 最大矩形
 *
 * <p>动态规划：使用柱状图的优化暴力方法
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
    	
    	// 边界
    	if(matrix.length == 0) return 0;
    	
    	int N = matrix.length;
    	int M = matrix[0].length;
    	
    	int[][] dp = new int[N][M];// 辅助矩阵
    	
    	int ans = 0;
    	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {// 定位矩形右下角
				// 跳过'0'
				if(matrix[i][j] == '0') continue;
				
				// 宽度
				dp[i][j] = j==0 ? 1 : dp[i][j-1] + 1;
				int width = dp[i][j];
				
				// 求可能的最大矩形面积
				for (int k = i; k >= 0; k--) {// 求矩形面积
					if(dp[k][j]==0) break;
					width = Math.min(dp[k][j], width); 
					ans = Math.max(ans, width * (i-k+1));
				}
			}
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	char[][] matrix = new char[][] {
    		{'1','0','1','0','0'},
    		{'1','0','1','1','1'},
    		{'1','1','1','1','1'},
    		{'1','0','0','1','0'}
    		};
    	
    	new Solution().maximalRectangle(matrix);
	}
}