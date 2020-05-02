package com.jasper.algs.leetcode.dynamicprogramming.qu0121.solu3;

/**
 * 0121.买卖股票的最佳时机
 * 
 * <p>一维DP，当天买入，找出此后最大值（逆序）
 */
class Solution {
    public int maxProfit(int[] prices) {
    	// 边界值
		if(prices==null || prices.length==0) return 0;
    	
		int N = prices.length;
		
    	int ans = 0; // 不买卖时，收益
    	int max = Integer.MIN_VALUE;
    	for (int i = N-1; i >= 0; i--) {
			if(prices[i]>max)
				max = prices[i];//更新最大值
			else {
				int profit = max - prices[i];
				if(profit>ans) //更新最大收益
					ans = profit;
			}
		}
    	
    	return ans;
    }
}