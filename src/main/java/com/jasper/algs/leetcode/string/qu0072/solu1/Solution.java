package com.jasper.algs.leetcode.string.qu0072.solu1;

/**
 * 0072. 编辑距离
 * 
 * <p> 动态规划
 */
class Solution {
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	
    	char[] sc1 = word1.toCharArray();
    	char[] sc2 = word2.toCharArray();
    	int[][] dp = new int[m+1][n+1];
    	for (int i = 0; i <= m; i++) {
			dp[i][0] = i;
		}
    	for (int j = 0; j <= n; j++) {
			dp[0][j] = j;
		}
    	for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = Math.min(dp[i-1][j], //删除 i
						dp[i][j-1]) + 1; // 添加 i
				dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + (sc1[i-1]==sc2[j-1]? 0 : 1)); // 替换i->j，或者不操作
			}
		}
    	
    	return dp[m][n];
    }
}