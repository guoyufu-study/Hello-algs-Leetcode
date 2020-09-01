package com.jasper.algs.leetcode.dp.qu0486.solu1;

/**
 * 0486. 预测赢家
 * 
 * <p> 动态规划
 */
class Solution {
    public boolean PredictTheWinner(int[] nums) {
    	int n = nums.length;
    	if(n%2==0) return true; // 偶数，先手必胜
    	
    	int[][] dp = new int[n][n];
    	for(int i=0; i<n; i++) dp[i][i] = nums[i];
    	for (int i = n-1; i >= 0; i--) {
			for (int j = i+1; j < n; j++) {
				dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
			}
		}
    	return dp[0][n-1] >= 0;
    }
}