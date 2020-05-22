package com.jasper.algs.leetcode.string.qu0010.solu3;

/**
 * 0010. 正则表达式匹配
 * 
 * <p> 动态规划：迭代求解
 */
class Solution {
    public boolean isMatch(String s, String p) {
    	
    	int n = s.length();
		int m = p.length();
		
		// 辅助数组
		boolean[][] dp = new boolean[n+1][m+1];
    	dp[n][m] = true;
    	
    	// 填充辅助数组
    	for (int i = n; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				
				// 匹配字母和.
		    	boolean firstMatch = i<n // 避免出现 s=""， p="a*"时数组越界问题
		    			&& (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
		    	
		    	// 匹配 * 
		    	if(j+1<m && p.charAt(j+1)=='*') {
		    		dp[i][j] = dp[i][j+2] || // 匹配0次
		    				(firstMatch && dp[i+1][j]);  // 匹配1次
		    	}
		    	// 匹配字母和.
		    	else {
		    		dp[i][j] = firstMatch && dp[i+1][j+1];
		    	}
			}
		}
    	
    	return dp[0][0];
    	
    }

}

