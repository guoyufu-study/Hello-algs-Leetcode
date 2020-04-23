package com.jasper.algs.leetcode.dynamicprogramming.qu0198.solu2;

/**
 * 0198.打家劫舍
 * <p> 动态规划
 */
class Solution {
    public int rob(int[] nums) {
    	int N = nums.length;
    	// 边界
    	if(N == 0) return 0;
    	if(N == 1) return nums[0];
    	
    	// 缓存状态
		int[] dp = new int[N];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		
		// 动态规划
		for (int i = 2; i < N; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		
		return dp[N-1];
    }
}