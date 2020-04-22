package com.jasper.algs.leetcode.dynamicprogramming.qu0746.solu4;

/**
 * 动态规划(优化)
 * 
 * <p>
 * F(i) = cost[i] + min(F(i-1), F(i-2))
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
    	int n = cost.length;
    	
    	// 边界值：只有一层台阶，直接跨过去
    	if(n==1) return 0;
    	
    	// 从-1层开始爬，cost[i]，站上第i层台阶，这一步需要花费的体力
		int costs1 = 0; // 站上第i-2层台阶，总共需要花费的最少体力
		int costs2 = 0; // 站上第i-1层台阶，总共需要花费的最少体力
		int costs; // 站上第i层台阶，总共需要花费的最少体力
    	for (int i = 0; i < n; i++) {
			costs = cost[i] + Math.min(costs1, costs2);
			costs1 = costs2;
			costs2 = costs;
		}
    	
    	// 目标：站上或跨过第n-1层台阶，总共需要花费的最少体力
    	return Math.min(costs1, costs2);
    }
}