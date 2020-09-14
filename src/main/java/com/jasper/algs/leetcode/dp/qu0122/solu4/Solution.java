package com.jasper.algs.leetcode.dp.qu0122.solu4;

/**
 * 0122. 买卖股票的最佳时机II
 *
 * <p>动态规划：状态压缩
 */
class Solution {
    public int maxProfit(int[] prices) {
    	if(prices==null || prices.length<=1)
    		return 0;
    	
    	int n = prices.length;
        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        int cash = 0, hold = -prices[0];
        int preCash = cash, preHold = hold;
        for (int i = 1; i < n; i++) {
        	hold = Math.max(preHold, preCash - prices[i]); // 买入股票，持有股票
            cash = Math.max(preCash, preHold + prices[i]); // 卖出股票，持有现金

            preHold = hold;
            preCash = cash;
        }
        return cash;
    }

}