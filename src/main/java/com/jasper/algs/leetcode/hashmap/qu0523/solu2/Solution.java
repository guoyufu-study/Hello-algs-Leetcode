package com.jasper.algs.leetcode.hashmap.qu0523.solu2;

/**
 * 0523. 连续的子数组和
 * 
 * <p> 暴力枚举 + 前缀和
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
    	int n = nums.length;
    	// 前缀和
    	int[] sum = new int[n+1];
    	for (int i = 0; i < n; i++) 
			sum[i+1] = sum[i] + nums[i];
		
    	// 暴力枚举
    	for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int dist = sum[j+1] - sum[i];
				if(dist==0 || (k!=0 && dist%k==0)) 
					return true;
			}
		}
    	return false;
    }
}