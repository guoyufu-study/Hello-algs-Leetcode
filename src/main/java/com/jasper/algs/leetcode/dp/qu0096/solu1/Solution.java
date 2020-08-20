package com.jasper.algs.leetcode.dp.qu0096.solu1;

/**
 * 0096. 不同的二叉搜索树
 * 
 * <p> 动态规划
 */
class Solution {
    public int numTrees(int n) {

    	int[] dp = new int[n+1];
    	dp[0] = 1;
    	for(int i=1; i<=n; i++) {
    		for(int j=1; j<=i; j++) {
    			dp[i] += dp[j-1] * dp[i-j];
    		}
    	}
    	return dp[n];
    }
}