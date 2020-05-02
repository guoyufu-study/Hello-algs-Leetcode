package com.jasper.algs.leetcode.dynamicprogramming.qu0123.solu2;

/**
 * 动态规划+辅助数组
 *
 */
class Solution {
    public int maxProfit(int[] prices) {
    	// 边界
    	if (prices.length <= 1 ) return 0;
    	
    	int N = prices.length;
        
    	//[0,i]，最大收益，顺序卖出
    	int[] lefts = new int[N];
    	lefts[0] = 0;
    	int min = prices[0];
    	for (int i = 1; i < N; i++) {
			if(prices[i] < min)
				min = prices[i];
			lefts[i] = Math.max(lefts[i-1], prices[i] - min);
		}
    	
    	//[i,N-1]，最大收益，逆序买入
    	int[] rights = new int[N];
    	rights[N-1] = 0;
    	int max = prices[N-1];
    	for (int i = N-2; i >= 0; i--) {
    		if(prices[i] > max)
    			max = prices[i];
    		
			rights[i] = Math.max(rights[i+1], max - prices[i]);
		}
    	
    	int ans = 0;
    	for (int i = 0; i < N; i++) { // profit = max(lefts[i]+right[i])
			ans = Math.max(ans, lefts[i]+rights[i]);
		}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] prices = new int[] {2,1,2,0,1};
		
		System.out.println(new Solution().maxProfit(prices));
	}
}