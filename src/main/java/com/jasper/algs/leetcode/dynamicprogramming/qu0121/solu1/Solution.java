package com.jasper.algs.leetcode.dynamicprogramming.qu0121.solu1;

/**
 * 暴力求解：尝试所有可能组合
 *
 */
class Solution {
    public int maxProfit(int[] prices) {
    	int ans = 0; // 不买卖时，收益
    	
    	for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {	
				int profit = prices[j]-prices[i];// 所有组合收益
				if(profit>ans)	// 更新最大收益
					ans = profit;
			}
		}
    	
    	return ans;
    }
}