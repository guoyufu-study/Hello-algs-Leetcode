package com.jasper.algs.leetcode.dp.qu0122.solu2;

/**
 * 0122. 买卖股票的最佳时机II
 *
 * <p>贪心算法
 */
class Solution {
    public int maxProfit(int[] prices) {
    	
    	// 边界条件
    	if(prices==null || prices.length==0) return 0;
    	
        int ans = 0;
        
        for (int i = 1; i < prices.length; i++) {
			if(prices[i]>prices[i-1])
				ans += prices[i]-prices[i-1];
		}
        
        return ans;
    	
    }
}