package com.jasper.algs.leetcode.dp.qu0312.solu3;

/**
 * 0312.戳气球
 * <p>
 * 动态规划
 */
class Solution {
    public int maxCoins(int[] nums) {
    	int n = nums.length;
    	
    	// 虚拟边界
    	int[] nums2 = new int[n+2];
    	System.arraycopy(nums, 0, nums2, 1, n);
    	nums2[0] = nums2[n+1] = 1;
    	nums = nums2;
    	
    	// 动态规划
    	int[][] dp = new int[n+2][n+2];
    	for (int s = n-1; s >= 0; s--) {
			for (int e = s+2; e < n+2; e++) {
				for (int i = s+1; i < e; i++) 
					dp[s][e] = Math.max(dp[s][e], dp[s][i]+dp[i][e]+nums[s]*nums[i]*nums[e]);
			}
		}
    	
    	return dp[0][n+1];
    }
}