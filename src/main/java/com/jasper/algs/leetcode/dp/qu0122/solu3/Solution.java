package com.jasper.algs.leetcode.dp.qu0122.solu3;

/**
 * 0122. 买卖股票的最佳时机II
 *
 * <p> 动态规划
 */
class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 动态规划
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0]; // 买入股票
        for (int i = 1; i < n; i++) {
        	// 持有现金，收益更多
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); // 持有现金、卖出股票
			// 持有股票：花费更少
			dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]); // 买入股票、持有股票
		}
        return dp[n-1][0];
    }

}