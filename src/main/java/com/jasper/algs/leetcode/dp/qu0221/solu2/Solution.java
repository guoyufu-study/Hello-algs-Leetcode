package com.jasper.algs.leetcode.dp.qu0221.solu2;

/**
 * 0221.最大正方形
 * 
 * <p>动态规划（优化）
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length==0) return 0; // 边界值
    	
        int rows = matrix.length, 
        	cols = matrix[0].length; //行列
       
        // 辅助数组
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        
        // 动态规划
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;//更新dp[j]，也就是下次计算用到的dp[j-1]
                    maxsqlen = Math.max(maxsqlen, dp[j]);//更新最大边长
                } else {
                    dp[j] = 0;
                }
                prev = temp;//更新下次要用的prev，也就是这次用的到dp[j]
            }
        }
        return maxsqlen * maxsqlen;
    }
}