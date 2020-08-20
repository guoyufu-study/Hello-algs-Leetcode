package com.jasper.algs.leetcode.dp.qu0070.solu2;

/**
 * 动态规划
 * 
 * <p>
 * 第 i 阶可以由两种方法得到：
 * <ol>
 * <li>在第 (i-1) 阶后向上爬1阶。
 * <li>在第 (i-2) 阶后向上爬 2阶。
 * </ol>
 * <p>所以，F(i) = F(i-1) + F(i-2);
 */
class Solution {
    public int climbStairs(int n) {
    	if(n<=1) 
    		return n;
    	
    	int[] dp = new int[n+1];
    	dp[1] = 1;
    	dp[2] = 2;
    	
    	for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
    	
    	return dp[n];
    }
    
}