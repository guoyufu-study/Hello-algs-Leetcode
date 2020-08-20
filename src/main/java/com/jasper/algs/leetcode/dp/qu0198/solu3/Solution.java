package com.jasper.algs.leetcode.dp.qu0198.solu3;

/**
 * 0198.打家劫舍
 * 
 * <p> 动态规划（优化）：压缩状态
 */
class Solution {
    public int rob(int[] nums) {
    	int N = nums.length;
    	// 边界
    	if(N == 0) return 0;
    	if(N == 1) return nums[0];
    	
    	// 缓存状态
		int dp0 = nums[0];
		int dp1 = Math.max(nums[0], nums[1]);
		
		// 动态规划
		for (int i = 2; i < N; i++) {
			int tmp = Math.max(dp1, dp0+nums[i]);
			dp0 = dp1;
			dp1 = tmp;
		}
		
		return dp1;
    }
}