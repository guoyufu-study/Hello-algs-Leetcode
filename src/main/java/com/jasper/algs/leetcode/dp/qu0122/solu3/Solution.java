package com.jasper.algs.leetcode.dp.qu0122.solu3;

/**
 * 0122. 买卖股票的最佳时机II
 *
 * <p>动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
        if (len == 0 ) return 0;

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);//卖出股票
            hold = Math.max(preHold, preCash - prices[i]);//买入股票

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

}