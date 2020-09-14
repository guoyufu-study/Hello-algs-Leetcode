package com.jasper.algs.leetcode.dp.qu0309.solu4;

/**
 * 0309. 最佳买卖股票时机含冷冻期
 * 
 * <p> 动态规划：空间优化
 */
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;

        int n = prices.length;
        int[][] dp = new int[3][2];
        dp[0][1] = -prices[0];
        dp[1][1] = Math.max(-prices[1], dp[0][1]);
        dp[1][0] = Math.max(0, -prices[0]+prices[1]);
        for (int i = 2; i < n; i++) {
			int a = (i-2)%3, b = (i-1)%3, c = i%3;
			dp[c][1] = Math.max(dp[a][0]-prices[i], dp[b][1]);
			dp[c][0] = Math.max(dp[b][0], dp[b][1]+prices[i]);
		}
        
        return dp[(n-1)%3][0];
    }
}