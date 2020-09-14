package com.jasper.algs.leetcode.dp.qu0188.solu3;

/**
 * 0188. 买卖股票的最佳时机 IV
 * 
 * <p> 买入时开启新一轮
 * <p> 动态规划
 */
class Solution {
    public int maxProfit(int k, int[] prices) {
    	if(prices==null || prices.length<=1)
    		return 0;
    	int n = prices.length;
    	
    	if(k > n/2) {
    		// 不限次数
    		int ans = 0;
    		for (int i = 1; i < n; i++) 
				if(prices[i]-prices[i-1]>0)
					ans += prices[i]-prices[i-1];
    		return ans;
    	}
    	
    	// 最多 k 次
    	int[][][] dp = new int[n][k+1][2];
    	for (int j = 1; j <= k; j++) {
			dp[0][j][1] = -prices[0];
		}
    	for (int i = 1; i < n; i++) {
			for (int j = k; j > 0; j--) {
				dp[i][j][1] = Math.max(dp[i-1][j-1][0]-prices[i], dp[i-1][j][1]);// 本轮买入
				dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);//本轮卖出
			}
		}
    	return dp[n-1][k][0];
    }
}