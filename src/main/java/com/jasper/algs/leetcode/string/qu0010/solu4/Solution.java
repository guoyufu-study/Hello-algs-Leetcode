package com.jasper.algs.leetcode.string.qu0010.solu4;

/**
 * 0010. 正则表达式匹配
 * 
 * <p> 从后往前
 * 
 * <p> 动态规划：迭代求解
 */
class Solution {
    public boolean isMatch(String s, String p) {
    	
    	int n = s.length();
		int m = p.length();
		
		// 辅助数组
		boolean[][] dp = new boolean[n+1][m+1];
    	dp[0][0] = true;
    	
    	

    	// 填充辅助数组
    	for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				// 匹配字母或.
                if (p.charAt(j - 1) != '*' &&
                		i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                	dp[i][j] = dp[i-1][j-1];
                } 
                // 匹配 *
                else {
                    // 已匹配 0 次
                    if (j >= 2) {
                        dp[i][j] |= dp[i][j - 2];
                    }
                    // 已匹配 1 次
                    if (i >= 1 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')) {
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
			}
		}
    	
    	return dp[n][m];
    	
    }
}