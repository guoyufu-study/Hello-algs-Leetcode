package com.jasper.algs.leetcode.dynamicprogramming.qu0746.solu3;

/**
 * 动态规划
 * 
 * <p>
 * F(i) = cost[i] + min(F(i-1), F(i-2))
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
    	int n = cost.length;
    	
    	// 边界值：只有一层台阶，直接跨过去
    	if(n==1) return 0;
    	
    	// 从-1层开始爬
    	// cost[i]，站上第i层台阶，这一步需要花费的体力
    	// costs[i]，站上（不含跨过）第i层台阶，总共需要花费的最少体力
		int[] costs = new int[n+1];
		costs[0] = cost[0];
		costs[1] = cost[1];
		
    	for (int i = 2; i < n; i++) {
			costs[i] = cost[i] + Math.min(costs[i-1], costs[i-2]); 
		}
    	
    	// 到达或跨过第n-1层台阶，总共需要花费的最少体力
    	costs[n] = Math.min(costs[n-1], costs[n-2]);
    	
    	return costs[n];
    }
}