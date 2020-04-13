package com.jasper.algs.leetcode.dynamicprogramming.qu0122.solu3;

/**
 * 动态规划
 */
class Solution {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
        if (len == 1 ) return 0;

        // cash：持有现金
        // hold：持有股票
        // 状态转移：cash → hold → cash → hold → cash → hold → cash

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }

}