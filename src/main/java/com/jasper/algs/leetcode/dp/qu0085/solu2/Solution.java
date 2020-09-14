package com.jasper.algs.leetcode.dp.qu0085.solu2;

/**
 * 0085. 最大矩形
 * 
 * <p> 动态规划：使用柱状图的优化暴力方法
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
    	// 边界
    	if(matrix.length == 0) return 0;
    	
    	int n = matrix.length, m = matrix[0].length, ans = 0;;
    	// 辅助矩阵
    	int[][] dp = new int[n][m+1];
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {// 定位矩形右下角
				// 跳过 '0'
				if(matrix[i][j] == '0') continue;
				
				// 宽度
				dp[i][j+1] = dp[i][j] + 1;
				int width = dp[i][j+1];
				
				// 求可能的最大矩形面积
				for (int k = i; k >= 0; k--) {// 求矩形面积
					if(dp[k][j+1]==0) break;
					width = Math.min(dp[k][j+1], width); 
					ans = Math.max(ans, width * (i-k+1));
				}
			}
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	// 6
    	char[][] matrix = new char[][] {
    		{'1','0','1','0','0'},
    		{'1','0','1','1','1'},
    		{'1','1','1','1','1'},
    		{'1','0','0','1','0'}
    		};
    	
    	System.out.println(new Solution().maximalRectangle(matrix));
	}
}