package com.jasper.algs.leetcode.string.qu0072.solu2;

/**
 * 0072. 编辑距离
 * 
 * <p> 动态规划 - 状态压缩
 */
class Solution {
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	
    	char[] sc1 = word1.toCharArray();
    	char[] sc2 = word2.toCharArray();
    	int[] dp = new int[n+1];
    	for (int j = 0; j <= n; j++) {
			dp[j] = j;
		}
    	
    	int prev = 0;
    	for (int i = 1; i <= m; i++) {
    		prev = dp[0];
    		dp[0] = i;
			for (int j = 1; j <= n; j++) {
				int tmp = Math.min(
						Math.min(dp[j], //删除 i
						dp[j-1]) + 1, // 添加 i
						prev + (sc1[i-1]==sc2[j-1]? 0 : 1)); // 替换i->j，或者不操作
				prev = dp[j];
				dp[j] = tmp;
			}
		}
    	
    	return dp[n];
    }
}