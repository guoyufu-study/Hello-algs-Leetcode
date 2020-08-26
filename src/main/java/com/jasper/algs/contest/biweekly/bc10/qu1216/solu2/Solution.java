package com.jasper.algs.contest.biweekly.bc10.qu1216.solu2;

/**
 * 1216. 验证回文字符串 III
 * 
 * <p> 动态规划
 */
class Solution {
    public boolean isValidPalindrome(String s, int k) {

    	char[] sc = s.toCharArray();
    	int n = s.length();
    	int[][] dp = new int[n][n];
    	for (int j = 1; j < n; j++) {
    		int i = j - 1;
			dp[i][j] = sc[i] == sc[j] ? 0 : 1;
		}
    	
    	for(int len=2; len<n; len++) {
    		for(int i=0; i + len<n; i++) {
    			int j = i + len;
    			dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
    			if(sc[i]==sc[j]) 
    				dp[i][j] = Math.min(dp[i][j], dp[i+1][j-1]);
    		}
    	}
    	
    	return dp[0][n-1]<=k;
    }
}