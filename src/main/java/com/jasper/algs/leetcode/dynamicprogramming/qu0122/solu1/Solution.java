package com.jasper.algs.leetcode.dynamicprogramming.qu0122.solu1;

/**
 * 暴力搜索
 *
 */
class Solution {

    private int ans;

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        
        ans = 0;
        
        dfs(prices, 0, len, 0, ans);
        
        return ans;
    }

    /**
     * @param prices 股价数组
     * @param index  当前是第几天，从 0 开始
     * @param status 0 表示不持有股票，1表示持有股票，
     * @param profit 当前收益
     */
    private void dfs(int[] prices, int index, int len, int status, int profit) {

        if (index == len) {
            this.ans = Math.max(this.ans, profit); // 更新最大收益
            return;
        }

        dfs(prices, index + 1, len, status, profit); // 不操作
        
        if (status == 0) //买入
            dfs(prices, index + 1, len, 1, profit - prices[index]);

        else //卖出
            dfs(prices, index + 1, len, 0, profit + prices[index]);
    }
}