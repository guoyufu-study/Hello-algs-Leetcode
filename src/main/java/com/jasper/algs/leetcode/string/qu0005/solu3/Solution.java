package com.jasper.algs.leetcode.string.qu0005.solu3;

/**
 * 0005. 最长回文子串
 * 
 * <p>动态规划
 */
public class Solution {

	public String longestPalindrome(String s) {
		
		// 边界
		if (s == null || s.length() <= 1) return s;
		
		int N = s.length();
		
		// 动态规划
		int maxLen=1, begin=0;
		boolean[][] dp = new boolean[N][N]; // 辅助二维数组
		for (int j = 1; j < N; j++) { // 按列填充
			for (int i = 0; i < j; i++) {
				if(s.charAt(i)!=s.charAt(j)) {
					dp[i][j] = false;
					continue ;
				} 
				
				if(j-i<3)// (j-i+1)-2<2
					dp[i][j] = true;
				else 
					dp[i][j] = dp[i+1][j-1];
				
				// 更新答案
				if(dp[i][j] && j-i+1>maxLen) {
					maxLen = j-i+1;
					begin = i;
				}
			}
		}
		
		
		return s.substring(begin, begin+maxLen);//左闭右开
	}
	
}
