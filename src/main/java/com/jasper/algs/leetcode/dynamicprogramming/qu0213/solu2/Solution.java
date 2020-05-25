package com.jasper.algs.leetcode.dynamicprogramming.qu0213.solu2;

/**
 * 0213.打家劫舍II
 * 
 * <p> 动态规划
 */
class Solution {
    public int rob(int[] nums) {
    	// 边界：空数组、长度1数组
    	if(nums==null || nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];

    	// 长度>=2数组
    	int N = nums.length;
    	
    	// 区间[0, N-2]
    	int[] dp = new int[N];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < N-1; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
		dp[0] = dp[N-2];
		
		// 区间[1, N-1]
		dp[1] = nums[1];
		dp[2] = Math.max(nums[1], nums[2]);
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
    	
		return Math.max(dp[0], dp[N-1]);
    }

}