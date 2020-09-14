package com.jasper.algs.leetcode.dp.qu0714.solu2;

/**
 * 0714. 买卖股票的最佳时机含手续费
 * 
 * <p> 动态规划：空间优化
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash=0, hold=-prices[0];
        int preCash=cash, preHold=hold;
        for(int i=1; i<n; i++){
            hold = Math.max(preCash-prices[i], preHold);
            cash = Math.max(preCash, preHold+prices[i]-fee);
            preCash=cash;
            preHold=hold;
        }

        return cash;
    }
}