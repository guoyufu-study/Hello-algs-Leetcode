package com.jasper.algs.leetcode.dynamicprogramming.qu0120.solu2;

import java.util.List;

/**
 * 0120. 三角形最小路径和
 * 
 * <p> 动态规划 + 状态压缩
 */
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int n = triangle.size();
    	
    	// 动态规划
    	int[] dp = new int[n];
    	dp[0] = triangle.get(0).get(0);
    	for (int i = 1; i < n; i++) {
			List<Integer> tmp = triangle.get(i);
			dp[i] = dp[i-1] + tmp.get(i);
    		for (int j = i-1; j > 0; j--) {
				dp[j] = Math.min(dp[j-1], dp[j]) + tmp.get(j);
			}
    		dp[0] = dp[0] + tmp.get(0);
		}
    	
    	// 最小值
    	int ans = dp[0];
    	for (int i = 1; i < n; i++) {
			ans = Math.min(ans, dp[i]);
		}
    	return ans;
    }
}