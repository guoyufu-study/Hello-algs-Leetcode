package com.jasper.algs.leetcode.dp.qu0300.solu1;

/**
 * 0300. 最长上升子序列
 * 
 * <p> 动态规划
 */
class Solution {
    public int lengthOfLIS(int[] nums) {

    	if(nums.length==0) return 0;
    	
    	int n = nums.length, ans = 0;
    	int[] dp = new int[n];
    	for (int i = 0; i < n; i++) {
            int max = 0;
			for (int j = 0; j < i; j++) {
				if(nums[j]<nums[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			ans = Math.max(ans, dp[i]);
		}
    	
    	return ans;
    }
}