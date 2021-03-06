package com.jasper.algs.leetcode.dp.qu0121.solu2;

/**
 * 0121.买卖股票的最佳时机
 * 
 * <p>一维DP，当天卖出，找出此前最小值（顺序）
 */
class Solution {
    public int maxProfit(int[] prices) {
    	// 边界值
    	if(prices==null || prices.length==0) return 0;
    	
    	int ans = 0; // 不买卖时，收益
    	int min = prices[0];
    	for (int i = 1; i < prices.length; i++) {
			if(prices[i]<min)
				min = prices[i];//更新最小值
			else {
				int profit = prices[i]-min;
				if(profit>ans) //更新最大收益
					ans = profit;
			}
		}
    	
    	return ans;
    	
    }
}